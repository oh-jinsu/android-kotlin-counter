package com.codersproduct.counter.stores

import com.codersproduct.counter.core.createStore
import com.codersproduct.counter.events.Decrement
import com.codersproduct.counter.events.Increment
import com.codersproduct.counter.events.Set

val counterStore = createStore<Int> { state, event ->
    val state = state ?: 0

    when(event) {
        is Set -> event.value
        is Increment -> state + 1
        is Decrement -> state - 1
        else -> state
    }
}