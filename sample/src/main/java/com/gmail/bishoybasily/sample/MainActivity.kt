package com.gmail.bishoybasily.sample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gmail.bishoybasily.messenger.Exchange
import com.gmail.bishoybasily.messenger.Subscriber

class MainActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    val exchange = Exchange()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subscriber1 = Subscriber<String>("user.#", Handler(Looper.myLooper()))
        subscriber1.handle { Log.i("##", "$it 1") }
        exchange.register(subscriber1)

        val subscriber2 = Subscriber<String>("user.*.add", Handler(Looper.myLooper()))
        subscriber2.handle { Log.i("##", "$it 2") }
        exchange.register(subscriber2)

        exchange.publish("Hello", "user.123.add")
    }
}
