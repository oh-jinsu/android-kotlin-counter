package com.codersproduct.counter.effects

import com.codersproduct.counter.core.Effect
import com.codersproduct.counter.core.dispatch
import com.codersproduct.counter.events.Random
import com.codersproduct.counter.events.Set

val setRandomNumber = { _: Random ->
    val random = java.util.Random().nextInt(100)

    dispatch(Set(random))
}