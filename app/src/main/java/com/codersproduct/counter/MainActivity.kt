package com.codersproduct.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.codersproduct.counter.core.useEffect
import com.codersproduct.counter.core.dispatch
import com.codersproduct.counter.core.useStoreManager
import com.codersproduct.counter.effects.setRandomNumber
import com.codersproduct.counter.events.Decrement
import com.codersproduct.counter.events.Increment
import com.codersproduct.counter.events.Random
import com.codersproduct.counter.stores.counterStore

class MainActivity : AppCompatActivity() {
    private val storeManager = useStoreManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.count).let { view ->
            storeManager.watch(counterStore) {
                view.text = it.toString()
            }
        }

        findViewById<Button>(R.id.button_increment).setOnClickListener {
            dispatch(Increment())
        }

        findViewById<Button>(R.id.button_decrement).setOnClickListener {
            dispatch(Decrement())
        }

        findViewById<Button>(R.id.button_random).setOnClickListener {
            dispatch(Random())
        }

        useEffect(setRandomNumber)
    }

    override fun onDestroy() {
        storeManager.dispose()

        super.onDestroy()
    }
}