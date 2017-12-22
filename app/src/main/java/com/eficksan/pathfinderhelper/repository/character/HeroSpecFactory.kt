package com.eficksan.pathfinderhelper.repository.character

/**
 * Created by Aleksei on 18.10.2017.
 */
interface HeroSpecFactory {
    fun findAll(): FindCharByNameSpec
    fun findHeroByName(name: String): FindCharByNameSpec
}