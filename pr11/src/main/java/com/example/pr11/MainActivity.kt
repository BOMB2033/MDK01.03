package com.example.pr11

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val text: TextView = findViewById(R.id.Text)
        val layot: ConstraintLayout = findViewById(R.id.main)
        when (item.itemId) {
            R.id.action_settings ->{
                layot.setBackgroundColor(ContextCompat.getColor(this,R.color.gray))
                text.text = "Настройки"
                Toast.makeText(this ,"Вы выбрали настройки", Toast.LENGTH_SHORT).show();
                return true
            }
            R.id.action1 ->{
                layot.setBackgroundColor(ContextCompat.getColor(this,R.color.blue))
                text.text = "Синий"
                Toast.makeText(this ,"Вы выбрали синий цвет", Toast.LENGTH_SHORT).show();
                return true
            }
            R.id.action2 ->{
                layot.setBackgroundColor(ContextCompat.getColor(this,R.color.blue))
                text.text = "Красный"
                Toast.makeText(this ,"Вы выбрали красный цвет", Toast.LENGTH_SHORT).show();
                return true
            }
            R.id.action3 ->{
                layot.setBackgroundColor(ContextCompat.getColor(this,R.color.green))
                text.text = "Зеленый"
                Toast.makeText(this ,"Вы выбрали зеленый цвет", Toast.LENGTH_SHORT).show();
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}