package com.jnicovm.minitwitter.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.jnicovm.minitwitter.di.DaggerMiniTwitterComponent
import com.jnicovm.minitwitter.di.MiniTwitterComponent
import dagger.Component


class MyApplication: Application() {

    lateinit var component: MiniTwitterComponent
        private set

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        component = initAppComponent()
    }

    private fun initAppComponent() = DaggerMiniTwitterComponent.factory().create(this)
}