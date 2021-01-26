package com.jnicovm.minitwitter.retrofit

import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import dagger.Module
import dagger.Provides

@Module
class APIModules {

    @Provides
    fun remoteLoginDataSourceProvider(
        loginRequest: LoginRequest
    ): RemoteLoginDataSource = LoginRetrofitDataSource(loginRequest)

}