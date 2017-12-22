package com.eficksan.pathfinderhelper

import android.app.Application
import com.eficksan.pathfinderhelper.di.AppComponent
import com.eficksan.pathfinderhelper.di.AppModule
import com.eficksan.pathfinderhelper.di.DaggerAppComponent
import com.eficksan.pathfinderhelper.di.RepositoryModule
import io.realm.Realm

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

        Realm.init(this)
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .repositoryModule(RepositoryModule(this))
                .build()
    }
}