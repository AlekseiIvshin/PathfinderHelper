package com.eficksan.pathfinderhelper.di

import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.HeroSpecFactory
import com.eficksan.pathfinderhelper.repository.realm.character.CharRepositoryRealm
import com.eficksan.pathfinderhelper.repository.realm.character.HeroSpecFactoryRealm
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 16.10.2017.
 */
@Module
class RepositoryModule(val app: App) {

    @Provides
    fun provideRepository(): CharRepository = CharRepositoryRealm()

    @Provides
    fun provideCharSpecFactory(): HeroSpecFactory = HeroSpecFactoryRealm()
}