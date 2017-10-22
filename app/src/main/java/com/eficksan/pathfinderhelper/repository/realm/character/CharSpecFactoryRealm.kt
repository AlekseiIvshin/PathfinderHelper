package com.eficksan.pathfinderhelper.repository.realm.character

import com.eficksan.pathfinderhelper.repository.character.CharSpecFactory
import com.eficksan.pathfinderhelper.repository.character.FindCharByNameSpec

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class CharSpecFactoryRealm : CharSpecFactory {
    override fun findAll(): FindCharByNameSpec = FindAllCharSpecRealm()

    override fun findCharByName(name: String): FindCharByNameSpec = FindCharByNameSpecRealm(name)
}