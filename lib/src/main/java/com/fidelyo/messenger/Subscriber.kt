package com.fidelyo.messenger

import android.os.Handler

/**
 * Created by bishoy on 7/21/17.
 */
class Subscriber<T>(var key: String, var handler: Handler) {

    var id: Long? = null
    var callback: Callback<T>? = null

    fun initializeThenPublish(obj: Any) {
        callback?.onMessage(obj as T)
    }

    interface Callback<T> {
        fun onMessage(t: T)
    }

}


