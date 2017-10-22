package com.eficksan.pathfinderhelper.di

import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpecFactory
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Aleksei
 * on 16.10.2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, RepositoryModule::class))
interface AppComponent {

    fun charRepository(): CharRepository
    fun charSpecRepository(): CharSpecFactory
}