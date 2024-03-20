package com.example.calculator

import android.content.Context
import android.util.AttributeSet
import android.widget.Button

class ResizableButton(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatButton(context!!, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        setMeasuredDimension(width, width)
    }
}