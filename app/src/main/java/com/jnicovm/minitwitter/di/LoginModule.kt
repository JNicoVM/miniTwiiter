package com.jnicovm.minitwitter.di

import com.jnicovm.minitwitter.activities.login.LoginViewModel
import com.jnicovm.minitwitter.useCases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class LoginModule {

    @Provides
    fun loginViewModelProvider(
        loginUseCase: LoginUseCase
    ) = LoginViewModel(loginUseCase)
}

@Subcomponent(modules = [(LoginModule::class)])
interface LoginComponent{
    val loginViewModel: LoginViewModel
}