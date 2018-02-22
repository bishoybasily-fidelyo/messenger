package com.fidelyo.messenger

/**
 * Created by bishoy on 7/21/17.
 */
open class ExchangeOld {

    val matcher: Matcher()

    fun register(subscriberOld: SubscriberOld<*>) {
        matcher.add(subscriberOld)
    }

    fun publish(message: Any, pubKey: String) {

        matcher.publish(pubKey).forEach { it. }

        it.key, pubKey

        map.values.filter { shouldIPublish() }.forEach { it.publish(message) }
    }

    fun unregister(subscriberOld: SubscriberOld<*>) {
        matcher.remove(subscriberOld)
    }


}