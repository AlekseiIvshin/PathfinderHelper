package com.eficksan.pathfinderhelper.modifyhero

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei on 18.02.2018.
 */
class ModifyHeroViewModel : ViewModel() {

    lateinit var heroesDao: HeroesDao

    private val id: MutableLiveData<String?> = MutableLiveData()
    val name: MutableLiveData<String?> = MutableLiveData()

    val laodedHeroData: LiveData<Hero> = Transformations.switchMap(
            id,
            { it -> heroesDao.searchById(it!!) })

    val results: MutableLiveData<Hero> = MutableLiveData()
    val errors:  MutableLiveData<Throwable> = MutableLiveData()

    fun onHeroModified(id: String) {
        this.id.value = id
    }

    fun generateHero(): Hero {
        return if (!isEdit()) {
            Hero.createNewHero(name.value!!)
        } else {
            Hero.createHero(id.value!!, name.value!!)
        }
    }

    fun isEdit(): Boolean = !id.value.isNullOrEmpty()
}