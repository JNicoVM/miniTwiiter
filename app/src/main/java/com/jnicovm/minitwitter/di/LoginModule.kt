package com.jnicovm.minitwitter.di

import com.jnicovm.minitwitter.activities.login.LoginViewModel
import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class LoginModule {

    @Provides
    fun loginViewModelProvider(
        loginRepository: LoginRepository,
        loginDao: LoginDao
    ) = LoginViewModel(loginRepository, loginDao)
}

@Subcomponent(modules = [(LoginModule::class)])
interface LoginComponent{
    val loginViewModel: LoginViewModel
}