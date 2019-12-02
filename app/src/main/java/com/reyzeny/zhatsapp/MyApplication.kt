package com.reyzeny.zhatsapp

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.reyzeny.zhatsapp.DI.AppComponent
import com.reyzeny.zhatsapp.DI.DaggerAppComponent
import com.reyzeny.zhatsapp.DI.NetworkModule


class MyApplication : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        AppCenter.start(this, "933d959d-cdcd-4384-bc04-68862cbd3c81", Analytics::class.java, Crashes::class.java)
        appComponent = DaggerAppComponent.builder()
            //.network(NetworkModule("ksjlf"))
            .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}
