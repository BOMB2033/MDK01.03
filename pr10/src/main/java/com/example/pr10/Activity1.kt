package com.example.pr10

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout


class Activity1 : AppCompatActivity() {
    lateinit var text: EditText
    var colors = arrayOf("#76A341","#386385","#874834")
    var sheetNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Debug", "onCreate")
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.text)
        sheetNumber = intent.getIntExtra("sheetNumber",0)
        val next: Button = findViewById(R.id.next)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val calculatedValue = progress + 10 // Range 10-24
                text.textSize = calculatedValue.toFloat()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        next.setOnClickListener {
            if (sheetNumber < colors.size -1){
                val intent = Intent(this, Activity1::class.java)
                intent.putExtra("sheetNumber", sheetNumber + 1)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext, getString(R.string.Next_Note), Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("Debug", "onPause")
        val prefs = getPreferences(Context.MODE_PRIVATE).edit()
        prefs.putString("note" + sheetNumber, text.editableText.toString())
            prefs.apply()
    }
    override fun onResume() {
        super.onResume()
        Log.i("Debug", "onResume")
        val sheet: ConstraintLayout = findViewById(R.id.sheet)
        sheet.setBackgroundColor(Color.parseColor(colors[sheetNumber]))
        val saveState = getPreferences(Context.MODE_PRIVATE).getString("note"+sheetNumber.toString(),null)
        if (saveState != null){
            text.setText(saveState)
        }
    }
}