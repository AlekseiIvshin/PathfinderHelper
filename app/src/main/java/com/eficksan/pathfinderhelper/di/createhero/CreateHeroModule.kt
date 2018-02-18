package com.eficksan.pathfinderhelper.di.createhero

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.eficksan.pathfinderhelper.createhero.*
import com.eficksan.pathfinderhelper.dao.RootDatabase
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.viewmodel.HeroNameViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
@Module
class CreateHeroModule(private val fragment: CreateHeroFragment) {

    @Provides
    @FragmentScope
    fun provideHeroesViewModel(): HeroNameViewModel =
            ViewModelProviders.of(fragment).get(HeroNameViewModel::class.java)

    @Provides
    @FragmentScope
    fun providePresenter(createHeroViewModel: CreateHeroViewModel): CreateHeroContract.Presenter =
            CreateHeroPresenter(fragment, createHeroViewModel)

    @Provides
    @FragmentScope
    fun provideAddNewHeroViewModel(rootDatabase: RootDatabase): CreateHeroViewModel {
        return ViewModelProviders.of(fragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
                CreateHeroViewModel::class.java -> CreateHeroViewModel(AddNewHeroUseCase(rootDatabase.heroesDao())) as T
                else -> throw IllegalArgumentException("No such factory for " + modelClass)
            }
        }).get(CreateHeroViewModel::class.java)
    }
}