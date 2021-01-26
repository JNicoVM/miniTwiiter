package com.jnicovm.minitwitter.data

import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.response.ResponseLogin
import io.reactivex.Observable

interface RemoteLoginDataSource {
    fun perfomLogin(requestLogin: RequestLogin) : Observable<ResponseLogin>
}