package com.example.pr13

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Image: ImageView = findViewById(R.id.imageView2)
        val Text: TextView = findViewById(R.id.Text)
        val Button: Button = findViewById(R.id.button)

        val popupmenu = androidx.appcompat.widget.PopupMenu(this,Image)
        popupmenu.inflate(R.menu.popuupmenu)
        popupmenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu1 -> {
                    Text.text ="Нажат пункт меню 1"

                    true
                }
                R.id.menu2 -> {
                    Text.text = "Нажат пункт меню 2"

                    true
                }
                R.id.menu3 -> {
                    Text.text = "Нажат пункт меню 3"
                    true
                }
                else -> false
            }
        }
        val popupmenu2 = PopupMenu(this, Button)
        popupmenu2.inflate(R.menu.popupmenu2)
        popupmenu2.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.red -> {
                    Text.background = ColorDrawable(Color.RED)
                    Text.text ="Вы выбрали красный цвет"
                    true
                }
                R.id.yellow -> {
                    Text.background = ColorDrawable(Color.YELLOW)
                    Text.text ="Вы выбрали жёлтый цвет"
                    true
                }
                R.id.green -> {
                    Text.background = ColorDrawable(Color.GREEN)
                    Text.text ="Вы выбрали зелёный цвет"
                    true
                }
            }
            false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            popupmenu2.setForceShowIcon(true)
        }
        Button.setOnClickListener {
            popupmenu2.show()
        }
        Image.setOnClickListener {
            popupmenu.show()
        }

    }
}