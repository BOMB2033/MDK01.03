package com.example.pr12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image: ImageView = findViewById(R.id.imageView3)
        val image2: ImageView = findViewById(R.id.ImageClock)
        val image3: ImageView = findViewById(R.id.ImageHourHand)
        val SunRiseAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.sun_rise)
        image.startAnimation(SunRiseAnim)
        val ClockTurnAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        image2.startAnimation(ClockTurnAnim)
        val Hour_Hand_Anim: Animation = AnimationUtils.loadAnimation(this, R.anim.hour_turn)
        image3.startAnimation(Hour_Hand_Anim)
    }
}