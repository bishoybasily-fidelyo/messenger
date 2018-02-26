# Local messaging for android

[![](https://jitpack.io/v/bishoybasily-fidelyo/messenger.svg)](https://jitpack.io/#bishoybasily-fidelyo/messenger)

## Overview

This library is about basic implementation for the rabbit-mq topic exchange,
the exchange you can filter it's messages by routing key.

## Example android kotlin

**Full example**
``` kotlin
import com.fidelyo.messenger.Exchange
import com.fidelyo.messenger.Subscriber
//...

val exchange = Exchange()
    
//...
 
val subscriber1 = Subscriber<String>("user.#", Handler(Looper.myLooper()))
subscriber1.handle { Log.i(TAG, it + " 1") }
exchange.register(subscriber1)

val subscriber2 = Subscriber<String>("user.*.add", Handler(Looper.myLooper()))
subscriber2.handle { Log.i(TAG, it + " 2") }
exchange.register(subscriber2)

exchange.publish("Hello", "user.123.add")
        
// ...
 
```

Moreover, you can extend the exchange and override "shouldIPublish" method to write your own routing decision