package com.eficksan.pathfinderhelper.repository.realm.character

import com.eficksan.pathfinderhelper.models.Character
import com.eficksan.pathfinderhelper.repository.character.FindCharByNameSpec
import com.eficksan.pathfinderhelper.repository.realm.RealmSpec
import io.realm.Realm
import io.realm.RealmQuery

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
class FindAllCharSpecRealm() : FindCharByNameSpec, RealmSpec<Character>() {
    override fun query(realm: Realm): RealmQuery<Character> =
            realm.where(Character::class.java)

}