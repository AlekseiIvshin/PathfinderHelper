package com.eficksan.pathfinderhelper.repository.realm.character

import com.eficksan.pathfinderhelper.repository.character.HeroSpecFactory
import com.eficksan.pathfinderhelper.repository.character.FindCharByNameSpec

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroSpecFactoryRealm : HeroSpecFactory {
    override fun findAll(): FindCharByNameSpec = FindAllCharSpecRealm()

    override fun findHeroByName(name: String): FindCharByNameSpec = FindCharByNameSpecRealm(name)
}