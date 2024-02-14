package com.example.practic4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView
    private lateinit var editText:EditText
    private lateinit var button: ImageButton
    private var numberStep:Int = 0
    private var nameF:String = "g"
    private var pogoda:String = "g"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView1)
        editText = findViewById(R.id.editText1)
        button = findViewById(R.id.buttonImage)
        editText.isVisible = false
        textView.text = "Привет!"
    }

    fun onClickImageButton(view: View) {
        when (numberStep)
        {
            0 ->{
            editText.isVisible = true
            textView.text = "Как тебя зовут?"
            }
            1->{
                nameF = editText.text.toString()
                textView.text = "Привет $nameF!\nКак тебе погода?"
                editText.text.clear()
            }
            2 ->{
                pogoda = editText.text.toString()
                textView.text = "Аааа, так это ты $nameF\n" +
                        "С этой фразой:$pogoda"
                editText.text.clear()
                editText.isVisible = false

            }
            3->{
                textView.text = "Иди от сюда"
            }
            4->{
                textView.textSize+=5
                textView.text = "$nameF ВАЛИИИИИ"
            }
            5->{
                textView.textSize-=5
                textView.text = ""
            }
            6 -> button.isVisible = false
        }
        numberStep++
    }
}