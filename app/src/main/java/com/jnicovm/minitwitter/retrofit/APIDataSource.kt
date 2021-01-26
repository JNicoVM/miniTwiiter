package com.jnicovm.minitwitter.retrofit

import com.google.gson.Gson
import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.response.ResponseLogin
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io

class LoginRetrofitDataSource(
    private val loginRequest: LoginRequest
): RemoteLoginDataSource {

    override fun perfomLogin(requestLogin: RequestLogin): Observable<ResponseLogin> {
        return loginRequest
            .getService<MiniTwitterService>()
            .doLoging(requestLogin)
            .map { it.let { Gson().fromJson(it, ResponseLogin::class.java) } }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io())
    }


}