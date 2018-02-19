package com.eficksan.pathfinderhelper.di.createhero

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.eficksan.pathfinderhelper.dao.RootDatabase
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.heroeslist.HeroesListViewModel
import com.eficksan.pathfinderhelper.modifyhero.*
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
@Module
class CreateHeroModule(private val fragment: ModifyHeroFragment) {

    @Provides
    @FragmentScope
    fun providePresenter(model: ModifyHeroViewModel,rootDatabase: RootDatabase): ModifyHeroContract.Presenter =
            ModifyHeroPresenter(fragment, model, AddNewHeroUseCase(rootDatabase.heroesDao()),UpdateHeroUseCase(rootDatabase.heroesDao()))

    @Provides
    @FragmentScope
    fun provideModifyHeroViewModel(rootDatabase: RootDatabase): ModifyHeroViewModel {
        val viewModel = ViewModelProviders.of(fragment).get(ModifyHeroViewModel::class.java)
        viewModel.heroesDao = rootDatabase.heroesDao()
        return viewModel
    }
}