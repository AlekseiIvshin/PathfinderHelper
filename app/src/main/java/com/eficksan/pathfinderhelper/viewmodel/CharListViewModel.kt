package com.eficksan.pathfinderhelper.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.eficksan.pathfinderhelper.models.Character
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpec

/**
 * Created by Aleksei on 18.10.2017.
 */
class CharListViewModel(val repository: CharRepository) : ViewModel() {

    private var charSpec: MutableLiveData<CharSpec> = MutableLiveData()

    var charsList: LiveData<List<Character>> = Transformations.switchMap(
            charSpec,
            { it -> CharListLiveData(repository, it) })

    fun setSpec(spec: CharSpec) {
        charSpec.value = spec
    }
}