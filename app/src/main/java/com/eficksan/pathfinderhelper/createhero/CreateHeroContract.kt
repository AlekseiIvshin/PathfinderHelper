package com.eficksan.pathfinderhelper.createhero

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.mvp.BaseView

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
interface CreateHeroContract {

    companion object {
        const val ERROR_NONE = -1
        const val ERROR_EMPTY_NAME = 0
        const val ERROR_NAME_EXIST = 1
    }

    interface Presenter : BasePresenter, LifecycleObserver {
        fun onNameChanged(name: CharSequence?)
        fun onSubmit()
    }

    interface View : BaseView<Presenter>, LifecycleOwner {
        fun isSubmitEnabled(isEnabled: Boolean)
        fun onHeroCreated()
        fun onHeroCreationError(errorCode: Int)
    }
}