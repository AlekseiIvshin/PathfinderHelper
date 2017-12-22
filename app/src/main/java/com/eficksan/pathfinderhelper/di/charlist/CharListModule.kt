package com.eficksan.pathfinderhelper.di.charlist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.eficksan.pathfinderhelper.charlist.HeroListFragment
import com.eficksan.pathfinderhelper.charlist.HeroListPresenter
import com.eficksan.pathfinderhelper.charlist.HeroListContract
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.HeroSpecFactory
import com.eficksan.pathfinderhelper.viewmodel.CharListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
@Module
class CharListModule(private val fragment: HeroListFragment) {

    @Provides
    fun provideViewModelFactory(repository: CharRepository): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>?): T = when (modelClass) {
                CharListViewModel::class.java -> CharListViewModel(repository) as T
                else -> throw IllegalArgumentException("No such factory for " + modelClass)
            }
        }
    }

    @Provides
    @FragmentScope
    fun provideTasksViewModel(viewModelFactory: ViewModelProvider.Factory): CharListViewModel =
            ViewModelProviders.of(fragment, viewModelFactory).get(CharListViewModel::class.java)

    @Provides
    @FragmentScope
    fun providePresenter(viewModel: CharListViewModel, repository: CharRepository, specFactory: HeroSpecFactory): HeroListContract.Presenter =
            HeroListPresenter(fragment, viewModel, repository, specFactory)
}