package com.cmartus.recycleviewproject

import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*
import java.util.Collections.shuffle
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val TAG = "Change"

    private var titlesList = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private var detailsList = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details", "Item five details",
        "Item six details", "Items seven details", "Items eight details")

    private var imagesList = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)
    private var randTitlesList = emptyArray<String>()
    private var randDetailsList = emptyArray<String>()
    private var randImagesList = emptyArray<Int>()


    fun randomize(){
        /*for (i in titlesList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
            randTitlesList += titlesList[j]
        }
        for (i in detailsList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
            randDetailsList += detailsList[j]
        }
        for (i in imagesList.size - 1 downTo 1) {
            val j = Random.nextInt(i+1)
           randImagesList += imagesList[j]
        }*/

       for (i in titlesList.size - 1 downTo 1) {
            val j = Random.nextInt(i + 1)
            val temp = titlesList[i]
            titlesList[i] = titlesList[j]
            titlesList[j] = temp
        }
        this.titlesList = titlesList
        for (i in detailsList.size - 1 downTo 1) {
            val j = Random.nextInt(i + 1)
            val temp = detailsList[i]
            detailsList[i] = detailsList[j]
            detailsList[j] = temp
        }
        this.detailsList = detailsList
        for (i in imagesList.size - 1 downTo 1) {
            val j = Random.nextInt(i + 1)
            val temp = imagesList[i]
            imagesList[i] = imagesList[j]
            imagesList[j] = temp
        }
        this.imagesList = imagesList
        Log.i(TAG, "fun complete")
    }


    fun getTitles(): Array<String> {
        Log.i(TAG, titlesList[1])
        return titlesList
    }
    fun getDetails(): Array<String>{
        return detailsList
    }
    fun getImages(): IntArray {
        return imagesList
    }

}