package com.eficksan.pathfinderhelper.repository.realm

import com.eficksan.pathfinderhelper.repository.Repository
import com.eficksan.pathfinderhelper.repository.Specification
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmResults

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
abstract class RealmRepository<T : RealmModel, S : Specification<T>> : Repository<T, S>,
        InTransaction by InTransactionDelegate(),
        DatabaseConnect by DatabaseConnectDelegate() {

    override fun addItem(item: T): T? {
        var addedItem: T? = null
        inTransaction {
            addedItem = it.copyToRealm(item)
        }
        return addedItem
    }

    override fun removeItem(spec: S): Int {
        var removedCount = 0
        inTransaction {
            val results = (spec as RealmSpec<T>).query(getDatabaseInstance()).findAll()
            removedCount = results.size
            results.deleteAllFromRealm()
        }
        return removedCount
    }

    override fun updateItem(item: T): T? {
        var addedItem: T? = null
        inTransaction {
            addedItem = it.copyToRealmOrUpdate(item)
        }
        return addedItem
    }

    override fun findItems(specification: S): Flowable<List<T>> {
        return Flowable.create<List<T>>({ emitter: FlowableEmitter<List<T>>? ->
            run {
                val results = (specification as RealmSpec<T>).query(getDatabaseInstance()).findAll()
                val realmResultListener: RealmChangeListener<RealmResults<T>> = RealmChangeListener { data ->
                    run {
                        if (!emitter!!.isCancelled) {
                            emitter.onNext(data.toList())
                        }
                    }
                }

                emitter?.setDisposable(Disposables.fromRunnable {
                    results.removeChangeListener(realmResultListener)
                })
                results.addChangeListener(realmResultListener)
                emitter?.onNext(results.toList())
            }
        }, BackpressureStrategy.LATEST)
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
    }

    override fun findItem(specification: S): Flowable<T> {
        return Flowable.create<T>({ emitter: FlowableEmitter<T>? ->
            run {
                val results = (specification as RealmSpec<T>).query(getDatabaseInstance()).findAll()
                val realmResultListener: RealmChangeListener<RealmResults<T>> = RealmChangeListener { data ->
                    run {
                        if (!emitter!!.isCancelled) {
                            emitter.onNext(data.first())
                        }
                    }
                }

                emitter?.setDisposable(Disposables.fromRunnable {
                    results.removeChangeListener(realmResultListener)
                })
                results.addChangeListener(realmResultListener)
                emitter?.onNext(results.first())
            }
        }, BackpressureStrategy.LATEST)
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
    }

}