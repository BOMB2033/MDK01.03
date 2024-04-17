package com.example.pr7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pr7.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private var countPress = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val backManager = BackgroundAndImageManager(binding)
        binding.imageView.setOnClickListener {
            backManager.setRandomColor()
            backManager.setRandomIC()
            binding.textView.text = getText(R.string.pressed).toString() + countPress++
            binding.textView.textSize = Random.nextInt(15,40).toFloat()
        }

    }
}