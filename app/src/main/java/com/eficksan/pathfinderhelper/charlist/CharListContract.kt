package com.eficksan.pathfinderhelper.charlist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import com.eficksan.pathfinderhelper.models.Character
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.mvp.BaseView

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
interface CharListContract {

    interface Presenter : BasePresenter, LifecycleObserver {
        fun onCreateNewChar()
        fun onCharSelected()
        fun onDeleteChar(name: String)
    }

    interface View : BaseView<Presenter>, LifecycleOwner {
        fun updateChars(chars: List<Character>?)
        fun showCreateCharacter()
    }
}