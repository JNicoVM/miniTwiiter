package com.jnicovm.minitwitter.di


import com.jnicovm.minitwitter.repository.LoginRepository
import com.jnicovm.minitwitter.useCases.LoginUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun perfomLogin(loginRepository: LoginRepository) =
        LoginUseCase(loginRepository)
}
