package com.eficksan.pathfinderhelper.mvp

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Aleksei on 18.02.2018.
 */
abstract class UseCase<P, R> {

    abstract fun getObservable(parameter: P): Observable<R>

    fun execute(parameter: P, observer: Observer<R>) {
        return getObservable(parameter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}