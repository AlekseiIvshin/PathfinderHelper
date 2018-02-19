package com.eficksan.pathfinderhelper.modifyhero

import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.UseCase
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableJust

/**
 * Created by Aleksei on 18.02.2018.
 */
class AddNewHeroUseCase(private val heroesDao: HeroesDao) : UseCase<Hero, Hero>() {

    override fun getObservable(parameter: Hero): Observable<Hero> {
        return ObservableJust(parameter)
                .map {
                    if (heroesDao.checkExistenceByName(it.id) > 0) {
                        throw HeroAlreadyExistsException()
                    } else {
                        heroesDao.insertHero(it)
                        return@map it
                    }
                }
    }


}