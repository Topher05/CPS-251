package com.cmartus.lifecycleaware.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    companion object{
        private var result: MutableLiveData<String> = MutableLiveData()
        fun addTo(logText: String){
            this.result.value += logText
        }
    }


    fun getResult(): MutableLiveData<String> {
        return result
    }
}