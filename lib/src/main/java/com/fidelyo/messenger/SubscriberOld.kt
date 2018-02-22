package com.fidelyo.messenger

import android.os.Handler

/**
 * Created by bishoy on 7/21/17.
 */
class SubscriberOld<T>(val key: String,
                       val handler: Handler) {

    val id: Long by lazy { System.currentTimeMillis() }

    private var callback: Callback<T>? = null

    fun handle(handler: (T) -> Unit) {
        callback = object : Callback<T> {
            override fun onMessage(t: T) {
                handler(t)
            }
        }
    }

    fun publish(obj: Any) {
        handler.post { callback?.onMessage(obj as T) }
    }


}


