package com.eficksan.pathfinderhelper.repository.realm

import com.eficksan.pathfinderhelper.repository.Specification
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
abstract class RealmSpec<T : RealmModel> : Specification<T> {
    abstract fun query(realm: Realm): RealmQuery<T>
}