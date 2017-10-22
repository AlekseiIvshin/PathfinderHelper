package com.eficksan.pathfinderhelper.di.charlist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.eficksan.pathfinderhelper.charlist.CharListFragment
import com.eficksan.pathfinderhelper.charlist.CharListPresenter
import com.eficksan.pathfinderhelper.charlist.CharListContract
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpecFactory
import com.eficksan.pathfinderhelper.viewmodel.CharListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
@Module
class CharListModule(private val fragment: CharListFragment) {

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
    fun providePresenter(viewModel: CharListViewModel, repository: CharRepository, specFactory: CharSpecFactory): CharListContract.Presenter =
            CharListPresenter(fragment, viewModel, repository, specFactory)
}