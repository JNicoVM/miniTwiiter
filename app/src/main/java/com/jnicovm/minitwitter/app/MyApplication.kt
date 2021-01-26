package com.jnicovm.minitwitter.app

import android.app.Application
import dagger.Component

@Component
interface ApplicationComponent { }

class MyApplication: Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}