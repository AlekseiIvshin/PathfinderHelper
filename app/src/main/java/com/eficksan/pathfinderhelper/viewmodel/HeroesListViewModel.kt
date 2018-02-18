package com.eficksan.pathfinderhelper.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei on 18.10.2017.
 */
class HeroesListViewModel(val heroesDao: HeroesDao) : ViewModel() {

    private var filter: MutableLiveData<String> = MutableLiveData()

    var heroesList: LiveData<List<Hero>> = Transformations.switchMap(
            filter,
            { it -> heroesDao.searchByName("%$it%") })

    fun filterByName(name: String) {
        filter.value = name
    }
}