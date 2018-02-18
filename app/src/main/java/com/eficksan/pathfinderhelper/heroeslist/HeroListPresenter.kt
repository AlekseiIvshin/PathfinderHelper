package com.eficksan.pathfinderhelper.heroeslist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.viewmodel.HeroesListViewModel

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroListPresenter(
        val view: HeroListContract.View,
        val viewModel: HeroesListViewModel,
        val heroesDao: HeroesDao): BasePresenter, HeroListContract.Presenter{

    var heroesListObserver: Observer<List<Hero>> = Observer { it -> view.updateHeroes(it) }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        viewModel.filterByName("")
        viewModel.heroesList.observe(view, heroesListObserver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        viewModel.heroesList.removeObserver { heroesListObserver }
    }

    override fun onCreateNewHero() {
        view.showCreateHeroScreen()
    }

    override fun onHeroSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleteHero(id: String) {
//        heroesDao.deleteHero(heroesDao.searchById(id))
    }

}