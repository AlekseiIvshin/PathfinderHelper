package com.eficksan.pathfinderhelper.di

import android.content.Context
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.realm.character.CharRepositoryRealm
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

}