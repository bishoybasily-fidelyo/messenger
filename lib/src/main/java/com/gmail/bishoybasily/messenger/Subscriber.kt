package com.gmail.bishoybasily.messenger

import android.os.Handler
import java.util.*

/**
 * Created by bishoy on 2/22/18.
 */

class Subscriber<T>(val key: String,
                    val handler: Handler) {

    private var callback: (T) -> Unit = {}
    private val uuid: UUID = UUID.randomUUID()

    fun handle(callback: (T) -> Unit) {
        this.callback = callback
    }

    fun publish(o: Any) {
        handler.post { callback.invoke(o as T) }
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as Subscriber<*>?

        return uuid == that!!.uuid
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }
}
