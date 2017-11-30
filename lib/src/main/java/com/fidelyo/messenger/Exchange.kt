package com.fidelyo.messenger

import com.google.gson.Gson
import io.reactivex.Observable
import java.io.Serializable

/**
 * Created by bishoy on 7/21/17.
 */
class Exchange
constructor(val gson: Gson) {

    val TAG = javaClass.simpleName

    val subscribersMap = hashMapOf<Long, Subscriber>()

    fun register(subscriber: Subscriber) {
        val nanoTime = System.currentTimeMillis()
        subscribersMap.put(nanoTime, subscriber.apply { id = nanoTime })
    }

    fun publish(message: Serializable, routingKey: String) {
        selectSubscribers(subscribersMap.values, routingKey).subscribe { subscriber ->
            subscriber.handler.post { subscriber.callback?.onMessage(gson.toJsonTree(message)) }
        }
    }

    fun unregister(subscriber: Subscriber) {
        subscribersMap.remove(subscriber.id)
    }

    private fun selectSubscribers(subscribers: Collection<Subscriber>, key: String): Observable<Subscriber> {
        return Observable.fromIterable(subscribers).filter { subscriber ->
            subscriber.key.equals(key)
        }
    }

}