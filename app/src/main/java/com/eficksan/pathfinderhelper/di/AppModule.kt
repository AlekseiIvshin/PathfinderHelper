package com.eficksan.pathfinderhelper.di

import android.arch.persistence.room.Room
import android.content.Context
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.dao.RootDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Aleksei
 * on 16.10.2017.
 */
@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun providesDatabase(context: Context): RootDatabase {
        return Room.databaseBuilder(context.applicationContext, RootDatabase::class.java, "pathfinder_db").build()
    }

}