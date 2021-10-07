package com.cmartus.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import com.cmartus.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculateTip(view: View) {

        if (binding.billAmount.text.isNotEmpty()){
            val billValue = binding.billAmount.text.toString().toFloat()
            val tip20 = "20% = " + String.format("%.2f",(billValue * 0.20 + billValue))
            val tip15 = "15% = " + String.format("%.2f",(billValue * 0.15 + billValue))
            val tip10 = "10% = " + String.format("%.2f",(billValue * 0.10 + billValue))
            val tipTxt ="The tips are as follows: "
            binding.outPut.text =  SpannableStringBuilder("$tipTxt\n\n$tip10\n$tip15\n$tip20")
        } else {
            binding.outPut.text = SpannableStringBuilder("You Must Enter A Bill Amount")
        }
    }
}