package com.eficksan.pathfinderhelper.charlist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.HeroSpecFactory
import com.eficksan.pathfinderhelper.viewmodel.CharListViewModel

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroListPresenter(
        val view: HeroListContract.View,
        val viewModel: CharListViewModel,
        val charRepository: CharRepository,
        val specFactory: HeroSpecFactory): BasePresenter, HeroListContract.Presenter{

    var heroesListObserver: Observer<List<Hero>> = Observer { it -> view.updateHeroes(it) }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        viewModel.setSpec(specFactory.findAll())
        viewModel.heroesList.observe(view, heroesListObserver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        viewModel.heroesList.removeObserver { heroesListObserver }
    }

    override fun onCreateNewChar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCharSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleteChar(name: String) {
        charRepository.removeItem(specFactory.findHeroByName(name))
    }

}