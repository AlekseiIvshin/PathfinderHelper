package com.eficksan.pathfinderhelper.createhero

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.viewmodel.StateBox

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class CreateHeroPresenter(
        val view: CreateHeroContract.View,
        val createHeroViewModel: CreateHeroViewModel
) : BasePresenter, CreateHeroContract.Presenter {

    var creationObserver = Observer<StateBox<Hero>> {
        when (it?.state) {
            StateBox.DONE -> view.onHeroCreated(it.data!!)
            StateBox.ERROR -> {
                when (it.error) {
                    is HeroAlreadyExistsException -> view.onHeroCreationError(CreateHeroContract.ERROR_NAME_EXIST)
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        createHeroViewModel.observe(view, creationObserver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        createHeroViewModel.removeObserver(creationObserver)
    }

    override fun onNameChanged(name: CharSequence?) {
        view.isSubmitEnabled(!name.isNullOrEmpty())
        if (name.isNullOrEmpty()) {
            createHeroViewModel.heroName.value = ""
            view.onHeroCreationError(CreateHeroContract.ERROR_EMPTY_NAME)
        } else {
            createHeroViewModel.heroName.value = name.toString().trim()
            view.onHeroCreationError(CreateHeroContract.ERROR_NONE)
        }
    }

    override fun onSubmit() {
        if (!createHeroViewModel.heroName.value.isNullOrEmpty()) {
            createHeroViewModel.execute(createHeroViewModel.heroName.value!!)
        }
    }

}