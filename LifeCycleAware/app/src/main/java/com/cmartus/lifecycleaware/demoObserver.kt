package com.cmartus.lifecycleaware

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import com.cmartus.lifecycleaware.ui.main.MainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class demoObserver: LifecycleObserver {

    private val LOG_TAG = "DemoObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.i(LOG_TAG, "onResume")
        MainViewModel.addTo("onResume was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i(LOG_TAG, "onPause")
        MainViewModel.addTo("onPause was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i(LOG_TAG, "onCreate")
        MainViewModel.addTo("onCreate was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i(LOG_TAG, "onStart")
        MainViewModel.addTo("onStart was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i(LOG_TAG, "onStop")
        MainViewModel.addTo("onStop was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i(LOG_TAG, "onDestroy")
        MainViewModel.addTo("onDestroy was fired on " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n *********** \n")
    }
}