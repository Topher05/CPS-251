package com.cmartus.recycleviewwithintentsproject

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*
import java.util.Collections.shuffle
import kotlin.random.Random

class MainViewModel: ViewModel() {

    companion object{
         var randTitlesList = emptyArray<String>()
         var randDetailsList = emptyArray<String>()
         var randImagesList = emptyArray<Int>()
    }

    private val TAG = "Change"

    var data: Data = Data()

    fun randomize(){
        for (i in data.titlesList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
            randTitlesList += data.titlesList[j]
        }
        for (i in data.detailsList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
            randDetailsList += data.detailsList[j]
        }
        for (i in data.imagesList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
           randImagesList += data.imagesList[j]
        }


    }

}