package com.eficksan.pathfinderhelper.models

import io.realm.RealmObject

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
open class Character(
        var name: String,
        var strength: Int,
        var dexterity: Int,
        var constitution: Int,
        var interlligence: Int,
        var wisdom: Int,
        var charisma: Int
): RealmObject() {
    constructor(): this("",10,10,10,10,10,10)
}