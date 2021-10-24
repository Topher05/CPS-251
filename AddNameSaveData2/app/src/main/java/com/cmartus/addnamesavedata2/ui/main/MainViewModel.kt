package com.cmartus.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var inputText: MutableLiveData<String> = MutableLiveData()
    var list: MutableList<String> = mutableListOf<String>()
    var names: MutableLiveData<String> = MutableLiveData()

    fun addList(){
        inputText.let {
            if(!it.value.equals("")){
                list.add(it.value.toString())
                for(l: String  in list){
                    names.value +=  l + "\n"
                }
            }
        }

    }


}