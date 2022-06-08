package com.codersproduct.counter.core

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer

interface StoreManager {
    fun<T> watch(store: Store<T>, eventListener: Consumer<in T>)

    fun dispose()
}

fun useStoreManager(): StoreManager {
    return object: StoreManager {
        private val disposables = mutableListOf<Disposable>()

        override fun<T> watch(store: Store<T>, eventListener: Consumer<in T>) {
            disposables.add(store.subscribe(eventListener))
        }

        override fun dispose() {
            disposables.forEach { it.dispose() }
        }
    }
}