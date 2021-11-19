package com.cmartus.recycleviewwithintentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

import com.cmartus.recycleviewwithintentsproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val titleString = extras.getString("title")
        val detailString = extras.getString("detail")
        val imageInt = extras.getInt("image")

        binding.titleText.text = titleString
        binding.detailText.text = detailString
        binding.img.setImageResource(imageInt)


    }
}