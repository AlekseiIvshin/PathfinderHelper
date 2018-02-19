package com.eficksan.pathfinderhelper.di.heroeslist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.eficksan.pathfinderhelper.dao.RootDatabase
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.heroeslist.DeleteHeroUseCase
import com.eficksan.pathfinderhelper.heroeslist.HeroListContract
import com.eficksan.pathfinderhelper.heroeslist.HeroListFragment
import com.eficksan.pathfinderhelper.heroeslist.HeroListPresenter
import com.eficksan.pathfinderhelper.viewmodel.HeroesListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
@Module
class HeroListModule(private val fragment: HeroListFragment) {

    @Provides
    @FragmentScope
    fun provideViewModelFactory(rootDatabase: RootDatabase): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
                HeroesListViewModel::class.java -> HeroesListViewModel(rootDatabase.heroesDao()) as T
                else -> throw IllegalArgumentException("No such factory for " + modelClass)
            }
        }
    }

    @Provides
    @FragmentScope
    fun provideHeroesViewModel(viewModelFactory: ViewModelProvider.Factory): HeroesListViewModel =
            ViewModelProviders.of(fragment, viewModelFactory).get(HeroesListViewModel::class.java)

    @Provides
    @FragmentScope
    fun provideDeleteUseCase(rootDatabase: RootDatabase): DeleteHeroUseCase = DeleteHeroUseCase(rootDatabase.heroesDao())

    @Provides
    @FragmentScope
    fun providePresenter(viewModel: HeroesListViewModel, deleteHeroUseCase: DeleteHeroUseCase): HeroListContract.Presenter =
            HeroListPresenter(fragment, viewModel, deleteHeroUseCase)
}