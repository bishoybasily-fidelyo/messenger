package com.fidelyo.messenger

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by bishoy on 7/21/17.
 */
open class Exchange {

    val map = ConcurrentHashMap<Long, Subscriber<*>>()

    fun register(subscriber: Subscriber<*>) {
        val nanoTime = System.currentTimeMillis()
        map.put(nanoTime, subscriber.apply { id = nanoTime })
    }

    fun publish(message: Any, pubKey: String) {
        map.values.filter { shouldIPublish(it.key, pubKey) }.forEach { it.publish(message) }
    }

    fun unregister(subscriber: Subscriber<*>) {
        map.remove(subscriber.id)
    }

    open fun shouldIPublish(subKey: String, pubKey: String): Boolean {
        return subKey.equals(pubKey)
    }

}