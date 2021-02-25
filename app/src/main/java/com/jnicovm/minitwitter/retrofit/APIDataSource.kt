package com.jnicovm.minitwitter.retrofit

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.response.ResponseLogin
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoginRetrofitDataSource(
    private val loginRequest: LoginRequest
): RemoteLoginDataSource {

    override fun perfomLogin(requestLogin: RequestLogin): Observable<JsonObject> {
        return configuracionRx(loginRequest
            .getService<MiniTwitterService>()
            .doLoging(requestLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io()))
    }
//    .map { Gson().fromJson(it, ResponseLogin::class.java) }

    fun configuracionRx(jsonObjectObservable: Observable<JsonObject>): Observable<JsonObject>
            =jsonObjectObservable.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .onErrorReturn(this::obtenerError)

    fun obtenerError(throwable: Throwable): JsonObject {
        val error="${throwable.message} Class: ${throwable.javaClass.name}"
        val jsonObject= JsonObject()
        val mensajeError= when(throwable) {
            is SocketTimeoutException -> error
            is UnknownHostException -> error
            else -> error
        }
        jsonObject.addProperty("response",mensajeError)
        return jsonObject
    }
}