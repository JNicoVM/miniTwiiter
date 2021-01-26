package com.jnicovm.minitwitter.di

import android.app.Application
import com.jnicovm.minitwitter.activities.login.LoginActivity
import com.jnicovm.minitwitter.repository.RepositoryModule
import com.jnicovm.minitwitter.retrofit.APIModules
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    APIModules::class,
    RepositoryModule::class
])
interface MiniTwitterComponent {

    fun inject(module: LoginModule): LoginComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MiniTwitterComponent
    }
}