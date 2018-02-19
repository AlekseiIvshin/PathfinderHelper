package com.eficksan.pathfinderhelper.heroeslist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.viewmodel.HeroesListViewModel
import io.reactivex.disposables.Disposable

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroListPresenter(
        val view: HeroListContract.View,
        val viewModel: HeroesListViewModel,
        val deleteHeroUseCase: DeleteHeroUseCase) : BasePresenter, HeroListContract.Presenter {

    private var heroesListObserver: Observer<List<Hero>> = Observer { it -> view.updateHeroes(it) }
    private var modeObserver: Observer<Int> = Observer { it -> view.setMode(it!!) }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        viewModel.filterByName("")
        viewModel.heroesList.observe(view, heroesListObserver)
        viewModel.mode.observe(view, modeObserver)
        if (viewModel.mode.value == null) {
            viewModel.mode.value = HeroListContract.MODE_LIST
        }
        view.setMode(viewModel.mode.value!!)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        viewModel.heroesList.removeObserver { heroesListObserver }
        viewModel.mode.removeObserver { modeObserver }
    }

    override fun onCreateNewHero() {
        view.showCreateHeroScreen()
    }

    override fun onDeleteModeOn() {
        viewModel.mode.value = HeroListContract.MODE_DELETE
    }

    override fun onEditModeOn() {
        viewModel.mode.value = HeroListContract.MODE_EDIT
    }

    override fun onCancelMode() {
        viewModel.mode.value = HeroListContract.MODE_LIST
    }

    override fun onHeroSelected(hero: Hero) {
        when (viewModel.mode.value) {
            HeroListContract.MODE_DELETE -> deleteHeroUseCase.execute(hero, object : io.reactivex.Observer<Unit> {
                override fun onNext(t: Unit) {}
                override fun onError(e: Throwable) {}
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {}
            })
        }
    }
}