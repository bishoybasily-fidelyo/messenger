package com.fidelyo.messenger

import android.os.Handler

/**
 * Created by bishoy on 7/21/17.
 */
class Subscriber<T>(internal var key: String,
                    internal var handler: Handler) {

    internal var id: Long? = null
    private var callback: Callback<T>? = null

    fun handle(handler: (T) -> Unit) {
        callback = object : Callback<T> {
            override fun onMessage(t: T) {
                handler(t)
            }
        }
    }

    internal fun publish(obj: Any) {
        handler.post { callback?.onMessage(obj as T) }
    }

}


