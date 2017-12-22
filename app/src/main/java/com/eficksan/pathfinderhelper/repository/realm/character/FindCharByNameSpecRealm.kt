package com.eficksan.pathfinderhelper.repository.realm.character

import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.repository.character.FindCharByNameSpec
import com.eficksan.pathfinderhelper.repository.realm.RealmSpec
import io.realm.Realm
import io.realm.RealmQuery

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
class FindCharByNameSpecRealm(val name: String): FindCharByNameSpec, RealmSpec<Hero>() {
    override fun query(realm: Realm): RealmQuery<Hero> =
            realm.where(Hero::class.java).equalTo("name", name)

}