package com.eficksan.pathfinderhelper.di

import android.content.Context
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpecFactory
import com.eficksan.pathfinderhelper.repository.realm.character.CharRepositoryRealm
import com.eficksan.pathfinderhelper.repository.realm.character.CharSpecFactoryRealm
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aleksei
 * on 16.10.2017.
 */
@Module
class RepositoryModule(val app: App) {

    @Provides
    fun provideRepository(): CharRepository = CharRepositoryRealm()

    @Provides
    fun provideCharSpecFactory(): CharSpecFactory = CharSpecFactoryRealm()
}