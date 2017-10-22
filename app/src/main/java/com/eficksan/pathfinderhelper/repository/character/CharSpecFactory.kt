package com.eficksan.pathfinderhelper.repository.character

/**
 * Created by Aleksei on 18.10.2017.
 */
interface CharSpecFactory {
    fun findAll(): FindCharByNameSpec
    fun findCharByName(name: String): FindCharByNameSpec
}