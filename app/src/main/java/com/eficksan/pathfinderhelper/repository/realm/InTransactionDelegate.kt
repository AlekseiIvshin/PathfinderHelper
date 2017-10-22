package com.eficksan.pathfinderhelper.repository.realm

import io.realm.Realm

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
class InTransactionDelegate: InTransaction {
    override fun inTransaction(body: (realm: Realm)->Unit) {
        with(Realm.getDefaultInstance()) {
            beginTransaction()
            body(this)
            commitTransaction()
        }
    }
}