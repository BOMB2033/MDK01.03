package com.example.pr8

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pr8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding)
        {
            buttonConfirm.setOnClickListener {
                try {
                    val colorText = Color.parseColor(editTextColor.text.toString())
                    val size = editTextSize.text.toString().toInt().toFloat()

                    textViewMain
                    textViewMain.apply {
                        textSize = size
                        setTextColor(colorText)
                    }
                }catch (e:Exception)
                {
                    Toast.makeText(this@MainActivity,  e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}