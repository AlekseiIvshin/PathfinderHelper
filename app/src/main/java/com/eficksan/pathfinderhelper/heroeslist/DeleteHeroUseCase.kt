package com.eficksan.pathfinderhelper.heroeslist

import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.mvp.UseCase
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableJust

/**
 * Created by Aleksei on 19.02.2018.
 */
class DeleteHeroUseCase(val heroesDao: HeroesDao) : UseCase<Hero, Unit>() {
    override fun getObservable(parameter: Hero): Observable<Unit> =
            ObservableJust(parameter)
                    .map { hero: Hero -> heroesDao.deleteHero(hero) }
}