package com.fidelyo.sample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.fidelyo.messenger.Exchange
import com.fidelyo.messenger.Subscriber

class MainActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    val exchange = Exchange()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subscriber1 = Subscriber<String>("user.*.*", Handler(Looper.myLooper()))
        subscriber1.handle { Log.i(TAG, it + " 1") }
        exchange.register(subscriber1)

        val subscriber2 = Subscriber<String>("user.123.#", Handler(Looper.myLooper()))
        subscriber2.handle { Log.i(TAG, it + " 2") }
        exchange.register(subscriber2)

        exchange.publish("Hello", "user.123.add")
    }
}
