package com.example.pr7

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.core.graphics.ColorUtils
import com.example.pr7.databinding.ActivityMainBinding
import kotlin.random.Random

class BackgroundAndImageManager(private var binding: ActivityMainBinding) {
    private fun setColor(colorInt: Int, darkColorRatio:Float){

        val colorIntDark = ColorUtils.blendARGB(colorInt, Color.BLACK, darkColorRatio)
        val colorIntLight = ColorUtils.blendARGB(colorInt, Color.WHITE, darkColorRatio)

        binding.backMain.setBackgroundColor(colorInt)
        binding.backDark.background.setColorFilter(colorIntDark, PorterDuff.Mode.SRC_ATOP)
        binding.backLight.background.setColorFilter(colorIntLight, PorterDuff.Mode.SRC_ATOP)
    }
    fun setRandomColor() {
        val random = Random
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)

        setColor( Color.rgb(red, green, blue), random.nextFloat())
    }
    private var drawableList = mutableListOf(
        R.drawable.ic_air,
        R.drawable.ic_bag,
        R.drawable.ic_bank,
        R.drawable.ic_bbq,
        R.drawable.ic_camera,
        R.drawable.ic_coconut,
        R.drawable.ic_compass,
        R.drawable.ic_diving,
        R.drawable.ic_drinks,
        R.drawable.ic_glasses,
        R.drawable.ic_hat,
        R.drawable.ic_hot,
        R.drawable.ic_hotel,
        R.drawable.ic_hight,
        R.drawable.ic_map,
        R.drawable.ic_medical,
        R.drawable.ic_pants,
        R.drawable.ic_parasol,
        R.drawable.ic_passport,
        R.drawable.ic_sailboat,
        R.drawable.ic_swimsuit,
        R.drawable.ic_tent
    )
    private fun updateListDrawable(){
        drawableList = mutableListOf(
            R.drawable.ic_air,
            R.drawable.ic_bag,
            R.drawable.ic_bank,
            R.drawable.ic_bbq,
            R.drawable.ic_camera,
            R.drawable.ic_coconut,
            R.drawable.ic_compass,
            R.drawable.ic_diving,
            R.drawable.ic_drinks,
            R.drawable.ic_glasses,
            R.drawable.ic_hat,
            R.drawable.ic_hot,
            R.drawable.ic_hotel,
            R.drawable.ic_hight,
            R.drawable.ic_map,
            R.drawable.ic_medical,
            R.drawable.ic_pants,
            R.drawable.ic_parasol,
            R.drawable.ic_passport,
            R.drawable.ic_sailboat,
            R.drawable.ic_swimsuit,
            R.drawable.ic_tent
        )
    }
    fun setRandomIC()
    {
        if (drawableList.isNotEmpty()){
            val indexRandom = Random.nextInt(drawableList.size)
            binding.imageView.setImageResource(drawableList[indexRandom])
            drawableList.removeAt(indexRandom)

        } else {
            updateListDrawable()
            val indexRandom = Random.nextInt(drawableList.size)
            binding.imageView.setImageResource(drawableList[indexRandom])
            drawableList.removeAt(indexRandom)
        }
    }

}