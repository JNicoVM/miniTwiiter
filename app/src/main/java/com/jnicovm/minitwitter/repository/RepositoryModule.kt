package com.jnicovm.minitwitter.repository

import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun loginRepositoryProvider(
        remoteLoginDataSource: RemoteLoginDataSource,
        loginDao: LoginDao
    ) = LoginRepository(
        remoteLoginDataSource,
        loginDao
    )
}