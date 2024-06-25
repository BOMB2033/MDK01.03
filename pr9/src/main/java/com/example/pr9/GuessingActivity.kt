package com.example.pr9

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pr9.databinding.ActivityGuessingBinding
import kotlin.random.Random

class GuessingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGuessingBinding
    private var max: Int = 100
    private var mid:Int = 0
    private var min: Int = 0

    private var maxA: Int = max
    private var minA: Int = min

    private var lateMaxA = max
    private var lateMidA:Int = 0
    private var lateMinA:Int = min

    private var lateMaxD:Int = max
    private var lateMinD:Int = min
    private var listNoInt:List<Int> = emptyList()

    private var isAskRange = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            askRange(min,max)

            buttonNo.setOnClickListener {

                if (isAskRange)
                    noRange()
                else
                    noLarger()
            }

            buttonYes.setOnClickListener {
                if (isAskRange)
                    yesRange()
                else
                    yeaLarger()
                if (min == max+1) textViewAsk.text == "Твоё число $min"
            }
        }
    }
    fun addNoInt(int:Int){
        listNoInt = listNoInt.plus(int)
    }

    fun noRange(){
        isAskRange = false
        lateMinD = minA
        lateMaxD = maxA
        if (minA == maxA){
            addNoInt(minA)
        }

        while (lateMidA == mid) {
            mid = random(minA,maxA)
        }
        lateMidA = mid
        askLarger(mid)

    }
    fun yesRange(){
        if(minA == maxA) {
            with(binding){
                textViewAsk.text = "Я выйграл твоё число " + minA

                buttonYes.visibility = View.GONE
                buttonNo.visibility = View.GONE
            }

            return
        }
        min = minA
        max = maxA
        while (lateMaxA == maxA && lateMinA == minA) {
            mid = random(min, max)
            minA = random(min, mid)
            maxA = random(mid, max)
        }
        lateMaxA = maxA
        lateMinA = minA
        askRange(minA,maxA)
    }

    fun noLarger(){
        isAskRange = true
        addNoInt(lateMidA)
        max = lateMinD
        min = min

        while ((lateMaxA == maxA && lateMinA == minA) || listNoInt.contains(maxA) || listNoInt.contains(minA) ) {
            mid = random(min, max)
            minA = random(min, mid)
            maxA = random(mid, max)
        }
        lateMaxA = maxA
        lateMinA = minA
        askRange(minA, maxA)
    }

    fun yeaLarger() {
        isAskRange = true
        max = max
        min = lateMaxD

        while (lateMaxA == maxA && lateMinA == minA) {
            mid = random(min, max)
            minA = random(min, mid)
            maxA = random(mid, max)
        }
        lateMaxA = maxA
        lateMinA = minA
        askRange(minA, maxA)


    }

    fun askRange(min:Int, max:Int){
        binding.textViewAsk.text = "Наверное твоё число в диапозоне от " + min + " до " + max + "?"
        if (min == max) binding.textViewAsk.text = "Твоё число $min?"

    }
    fun askLarger(number:Int){
        binding.textViewAsk.text = "Твоё число больше или равно " + number + "?"
        if (min == max)  binding.textViewAsk.text = "Твоё число $min"

    }
    fun random(min:Int, max:Int) = Random.nextInt(min, max+1)

}