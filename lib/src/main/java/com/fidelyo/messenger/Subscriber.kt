package com.fidelyo.messenger

import android.os.Handler
import com.google.gson.JsonElement

/**
 * Created by bishoy on 7/21/17.
 */
class Subscriber(var key: String, var handler: Handler) {

    var id: Long? = null
    var callback: Callback? = null

    interface Callback {
        fun onMessage(jsonElement: JsonElement)
    }

}