package com.jnicovm.minitwitter.retrofit

import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.request.RequestSignUp
import retrofit2.http.Body
import retrofit2.http.POST
import com.google.gson.JsonObject
import io.reactivex.Observable

interface MiniTwitterService {

    /** API LOGIN*/
    @POST(APIConstants.KEY_LOGIN)
    fun doLoging(@Body requestLogin: RequestLogin) : Observable<JsonObject>

    /** API LOGIN*/
    @POST(APIConstants.KEY_SIGNUP)
    fun doSignUp(@Body requetSignUp: RequestSignUp) : Observable<JsonObject>
}