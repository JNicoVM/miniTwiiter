package com.jnicovm.minitwitter.retrofit

import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import com.jnicovm.minitwitter.retrofit.APIConstants.BASE_API_URL
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class APIModules{

    @Provides
    fun loginRequestProvider(
        @Named("baseUrl") baseUrl: String
    ) = LoginRequest(baseUrl)

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = BASE_API_URL

    @Provides
    fun remoteLoginDataSourceProvider(
        loginRequest: LoginRequest
    ): RemoteLoginDataSource = LoginRetrofitDataSource(loginRequest)

}