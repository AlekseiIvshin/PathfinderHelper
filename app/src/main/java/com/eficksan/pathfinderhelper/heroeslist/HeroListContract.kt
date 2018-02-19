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

    companion object {
        const val MODE_LIST = 0
        const val MODE_DELETE = 1
        const val MODE_EDIT = 2
    }

    interface Presenter : BasePresenter, LifecycleObserver {
        fun onCreateNewHero()
        fun onDeleteModeOn()
        fun onEditModeOn()
        fun onCancelMode()
        fun onHeroSelected(hero: Hero)
    }

    interface View : BaseView<Presenter>, LifecycleOwner {
        fun updateHeroes(heroes: List<Hero>?)
        fun showCreateHeroScreen()
        fun setMode(modeCode: Int)
    }
}