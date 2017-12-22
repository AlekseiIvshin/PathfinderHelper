package com.eficksan.pathfinderhelper.models

import io.realm.RealmObject

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
open class Hero(
        var name: String,
        var ability: Ability
): RealmObject() {
    constructor(): this("", Ability())
}