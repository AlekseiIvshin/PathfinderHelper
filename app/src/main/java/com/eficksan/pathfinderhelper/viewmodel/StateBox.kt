package com.eficksan.pathfinderhelper.viewmodel

/**
 * Created by Aleksei on 18.02.2018.
 */
class StateBox<T>(val state: Int,
                  val data: T? = null,
                  val error: Throwable? = null
) {

    companion object {
        const val ERROR = -1
        const val IN_PROGRESS = 0
        const val DONE = 1

        fun <T> onStarted(): StateBox<T> = StateBox(IN_PROGRESS)

        fun <T> onError(error: Throwable) = StateBox<T>(ERROR, null, error)

        fun <T> onComplete(data: T) = StateBox(DONE, data)
    }
}