package com.jnicovm.minitwitter.dao

import dagger.Module
import dagger.Provides

@Module
class LoginDaoModule {

    @Provides
    fun loginDaoProvider() = LoginDao()
}