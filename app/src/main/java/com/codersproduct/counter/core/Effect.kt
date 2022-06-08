package com.codersproduct.counter.core

typealias Effect<T> = (event: T) -> Unit

inline fun<reified T> useEffect(noinline effect: Effect<T>) {
   return useEffect(T::class.java, effect)
}

fun<T> useEffect(event: Class<T>, effect: Effect<T>) {
    channel.subscribe {
        if (it::class.java == event) {
           effect(it as T)
        }
    }
}