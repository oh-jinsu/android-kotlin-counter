package com.codersproduct.counter.core

typealias Reducer<T> = (state: T?, event: Any?) -> T?
