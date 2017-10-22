package com.eficksan.pathfinderhelper.repository

import io.reactivex.Flowable

/**
 * Created by Aleksei
 * on 17.10.2017.
 */
interface Repository<T, S : Specification<T>> {
    fun addItem(item: T): T?
    fun removeItem(spec: S): Int
    fun updateItem(item: T): T?
    fun findItems(specification: S): Flowable<List<T>>
    fun findItem(specification: S): Flowable<T>
}