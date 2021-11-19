package com.cmartus.recycleviewwithintentsproject

data class Data(
    var titlesList: Array<String> = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
"Chapter Five", "Chapter Six", "Chapter Seven",
"Chapter Eight"),

    var detailsList: Array<String> = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details", "Item five details",
        "Item six details", "Items seven details", "Items eight details"),

    var imagesList: IntArray = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)
)

