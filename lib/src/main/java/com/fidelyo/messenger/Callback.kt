package com.fidelyo.messenger

interface Callback<T> {

    fun onMessage(t: T)

}