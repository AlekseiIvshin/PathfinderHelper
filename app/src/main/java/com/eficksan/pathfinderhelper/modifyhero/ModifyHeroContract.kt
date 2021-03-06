package com.eficksan.pathfinderhelper.modifyhero

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.mvp.BaseView

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
interface ModifyHeroContract {

    companion object {
        const val ERROR_NONE = -1
        const val ERROR_EMPTY_NAME = 0
        const val ERROR_NAME_EXIST = 1
    }

    interface Presenter : BasePresenter, LifecycleObserver {
        fun onNameChanged(name: CharSequence?)
        fun onSubmit()
        fun onEditHero(heroId: String)
    }

    interface View : BaseView<Presenter>, LifecycleOwner {
        fun isSubmitEnabled(isEnabled: Boolean)
        fun onHeroCreated(newHero: Hero)
        fun onHeroCreationError(errorCode: Int)
        fun updateHero(hero: Hero)
        fun onHeroUpdated(hero: Hero)
    }
}