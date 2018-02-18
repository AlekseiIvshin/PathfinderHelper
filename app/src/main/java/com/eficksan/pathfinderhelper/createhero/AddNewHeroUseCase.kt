package com.eficksan.pathfinderhelper.createhero

import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.UseCase
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableJust

/**
 * Created by Aleksei on 18.02.2018.
 */
class AddNewHeroUseCase(private val heroesDao: HeroesDao) : UseCase<String, Unit>() {

    override fun getObservable(heroName: String): Observable<Unit> {
        return ObservableJust(heroName)
                .map {
                    if (heroesDao.checkExistenceByName(it) > 0) {
                        throw HeroAlreadyExistsException()
                    } else {
                        heroesDao.insertHero(Hero.createNewHero(heroName))
                    }
                }
    }


}