package com.codersproduct.counter.core

import io.reactivex.rxjava3.subjects.PublishSubject

internal val channel = PublishSubject.create<Any?>()

fun dispatch(event: Any?) = channel.onNext(event)


