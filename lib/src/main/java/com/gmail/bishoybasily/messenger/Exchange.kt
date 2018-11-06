package com.gmail.bishoybasily.messenger

/**
 * Created by bishoy on 2/22/18.
 */

class Exchange {

    private val matcher = Matcher()

    fun register(subscriber: Subscriber<*>) {
        matcher.add(subscriber)
    }

    fun publish(obj: Any, key: String) {
        matcher.matches(key).forEach { subscriber -> subscriber.publish(obj) }
    }

    fun unregister(subscriber: Subscriber<*>) {
        matcher.remove(subscriber)
    }

}
