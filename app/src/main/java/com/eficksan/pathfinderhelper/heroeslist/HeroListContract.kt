package com.eficksan.pathfinderhelper.heroeslist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.mvp.BaseView

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
interface HeroListContract {

    interface Presenter : BasePresenter, LifecycleObserver {
        fun onCreateNewHero()
        fun onHeroSelected()
        fun onDeleteHero(name: String)
    }

    interface View : BaseView<Presenter>, LifecycleOwner {
        fun updateHeroes(heroes: List<Hero>?)
        fun showCreateHeroScreen()
    }
}