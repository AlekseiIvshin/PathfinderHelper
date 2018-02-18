package com.eficksan.pathfinderhelper.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.eficksan.pathfinderhelper.mvp.UseCase
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Aleksei on 18.10.2017.
 */
open class UseCaseViewModel<P, R>(val useCase: UseCase<P, R>) : ViewModel() {

    private var subscription: MutableLiveData<Disposable?> = MutableLiveData()

    var state: MutableLiveData<StateBox<R>> = MutableLiveData()

    fun execute(param: P) {
        state.value = StateBox.onStarted()
        useCase.execute(param, object : Observer<R> {
            override fun onComplete() {
            }

            override fun onNext(t: R) {
                state.value = StateBox.onComplete(t)
            }

            override fun onSubscribe(d: Disposable) {
                subscription.value = d
            }

            override fun onError(e: Throwable) {
                state.value = StateBox.onError(e)
            }
        })
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: android.arch.lifecycle.Observer<StateBox<R>>) =
            state.observe(lifecycleOwner, observer)


    fun removeObserver(observer: android.arch.lifecycle.Observer<StateBox<R>>) = state.removeObserver(observer)

    fun cancel() = subscription.value?.dispose()

}