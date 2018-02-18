package com.eficksan.pathfinderhelper.di

import com.eficksan.pathfinderhelper.dao.RootDatabase
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Aleksei
 * on 16.10.2017.
 */
@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    fun rootDatabase(): RootDatabase
}