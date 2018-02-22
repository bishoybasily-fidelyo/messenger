package com.fidelyo.sample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fidelyo.messenger.ExchangeOld
import com.fidelyo.messenger.SubscriberOld

class MainActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    val exchange = ExchangeOld()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subscriber1 = SubscriberOld<String>("routing_key1", Handler(Looper.myLooper()))
        subscriber1.handle { Log.i(TAG, it + " 1") }
        exchange.register(subscriber1)

        val subscriber2 = SubscriberOld<String>("routing_key2", Handler(Looper.myLooper()))
        subscriber2.handle { Log.i(TAG, it + " 2") }
        exchange.register(subscriber2)

        exchange.publish("Hello", "routing_key2")
    }
}
