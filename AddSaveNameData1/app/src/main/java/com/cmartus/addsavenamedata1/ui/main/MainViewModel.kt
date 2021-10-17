package com.cmartus.addsavenamedata1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nameText = ""
    private var nameList = mutableListOf<String>()

    fun addNames(value: String){
        this.nameText = value
        nameList.add(nameText)
    }
    fun getNameList(): MutableList<String> {
        return nameList
    }
}