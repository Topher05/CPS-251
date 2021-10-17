package com.cmartus.addsavenamedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmartus.addsavenamedata1.databinding.ActivityMainBinding
import com.cmartus.addsavenamedata1.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }

}
