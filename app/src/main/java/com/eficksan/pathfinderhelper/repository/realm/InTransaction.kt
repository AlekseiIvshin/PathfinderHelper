package com.eficksan.pathfinderhelper.repository.realm

import io.realm.Realm

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
interface InTransaction {
    fun inTransaction(body: (realm: Realm)->Unit)
}