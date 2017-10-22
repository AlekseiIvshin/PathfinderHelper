package com.eficksan.pathfinderhelper.viewmodel

import android.arch.lifecycle.LiveData
import com.eficksan.pathfinderhelper.models.Character
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpec
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class CharListLiveData(val repository: CharRepository, var spec: CharSpec) : LiveData<List<Character>>() {

    var subscription: Disposable? = null

    var changeListener: Consumer<List<Character>> = Consumer { setValue(value) }

    override fun onActive() {
        subscription = repository.findItems(spec).subscribe(changeListener)
    }

    override fun onInactive() {
        subscription?.dispose()
    }
}