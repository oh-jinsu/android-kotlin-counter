package com.codersproduct.counter.core

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.subjects.BehaviorSubject

interface Store<T> {
    fun subscribe(onNext: Consumer<in T>): Disposable

    val state: T?
}

fun<T> createStore(reducer: Reducer<T>): Store<T> {
    val initialState = reducer(null, null)

    val subject = BehaviorSubject.createDefault<T>(initialState)

    channel.subscribe { event ->
        val result = reducer(subject.value, event)

        subject.onNext(result)
    }

    return object : Store<T> {
        override fun subscribe(onNext: Consumer<in T>): Disposable {
            return subject.subscribe(onNext)
        }

        override val state: T? get() = subject.value
    }
}