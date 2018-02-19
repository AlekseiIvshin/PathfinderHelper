package com.eficksan.pathfinderhelper.modifyhero

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import io.reactivex.disposables.Disposable

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class ModifyHeroPresenter(
        val view: ModifyHeroContract.View,
        val modifyHeroViewModel: ModifyHeroViewModel,
        val addNewHeroUseCase: AddNewHeroUseCase,
        val updateHeroUseCase: UpdateHeroUseCase
) : BasePresenter, ModifyHeroContract.Presenter {

    var resultsObserver = Observer<Hero> {
        if (modifyHeroViewModel.isEdit()) {
            view.onHeroUpdated(it!!)
        } else {
            view.onHeroCreated(it!!)
        }
    }

    var errorsObserver = Observer<Throwable> {
        when (it) {
            is HeroAlreadyExistsException -> view.onHeroCreationError(ModifyHeroContract.ERROR_NAME_EXIST)
        }
    }

    var editHeroObserver = Observer<Hero> {
        view.updateHero(it!!)
    }

    val observer: io.reactivex.Observer<Hero> = object : io.reactivex.Observer<Hero> {
        override fun onError(error: Throwable) {
            modifyHeroViewModel.errors.value = error
        }

        override fun onComplete() {}
        override fun onSubscribe(d: Disposable) {}
        override fun onNext(hero: Hero) {
            modifyHeroViewModel.results.value = hero
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        modifyHeroViewModel.results.observe(view, resultsObserver)
        modifyHeroViewModel.errors.observe(view, errorsObserver)
        modifyHeroViewModel.laodedHeroData.observe(view, editHeroObserver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        modifyHeroViewModel.results.removeObserver(resultsObserver)
        modifyHeroViewModel.errors.removeObserver(errorsObserver)
        modifyHeroViewModel.laodedHeroData.removeObserver(editHeroObserver)
    }

    override fun onNameChanged(name: CharSequence?) {
        view.isSubmitEnabled(!name.isNullOrEmpty())
        if (name.isNullOrEmpty()) {
            modifyHeroViewModel.name.value = ""
            view.onHeroCreationError(ModifyHeroContract.ERROR_EMPTY_NAME)
        } else {
            modifyHeroViewModel.name.value = name.toString().trim()
            view.onHeroCreationError(ModifyHeroContract.ERROR_NONE)
        }
    }

    override fun onSubmit() {
        if (!modifyHeroViewModel.name.value.isNullOrEmpty()) {
            if (modifyHeroViewModel.isEdit()) {
                updateHeroUseCase.execute(modifyHeroViewModel.generateHero(), observer)
            } else {
                addNewHeroUseCase.execute(modifyHeroViewModel.generateHero(),observer)
            }
        }
    }

    override fun onEditHero(heroId: String) {
        modifyHeroViewModel.onHeroModified(heroId)
    }

}