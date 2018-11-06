# Local messaging for android

[![](https://jitpack.io/v/bishoybasily/messenger.svg)](https://jitpack.io/#bishoybasily/messenger)

## Overview

This library is about basic implementation for the rabbit-mq topic exchange,
the exchange you can filter it's messages by routing key.

## Example android kotlin

**Full example**
``` kotlin
import com.gmail.bishoybasily.messenger.Exchange
import com.gmail.bishoybasily.messenger.Subscriber
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
