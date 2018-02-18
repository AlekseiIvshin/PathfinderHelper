package com.eficksan.pathfinderhelper

import android.app.Application
import com.eficksan.pathfinderhelper.di.AppComponent
import com.eficksan.pathfinderhelper.di.AppModule
import com.eficksan.pathfinderhelper.di.DaggerAppComponent

/**
 * Created by Aleksei
 * on 16.10.2017.
 */
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}