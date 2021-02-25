package com.jnicovm.minitwitter.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseRequest<T: Any>(
    private var baseUrl: String
) {

    private val interceptor= HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(40, TimeUnit.SECONDS)
        .build()

    inline fun <reified T:Any> getService(): T =
        buildRetrofit().run {
            create(T::class.java)
        }


    fun buildRetrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
}

class LoginRequest(baseUrl: String): BaseRequest<MiniTwitterService>(baseUrl)

