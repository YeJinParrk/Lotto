package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.*
import java.util.Random
import kotlin.collections.ArrayList

fun getRandomLottoNumber ():Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers (): MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()

    while (true) {
        val number = getRandomLottoNumber()
        var flag_exist = 0

        if (lottoNumbers.size < 1) {
            lottoNumbers.add(number)
            continue
        } else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j]) {
                    flag_exist = 1
                    break
                }
            }

            if (flag_exist == 0)
                lottoNumbers.add(number)
            if (lottoNumbers.size >= 6)
                break
        }
    }
    return lottoNumbers
}

fun getsuffledLottoNumbers() : MutableList<Int>{
    val list = mutableListOf<Int>()

    for(number in 1..45){
        list.add(number)
    }
    list.shuffle()

    return list.subList(0,6)
}

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val RandomCard = findViewById<CardView>(R.id.cardview1)
            val constellationCard = findViewById<CardView>(R.id.cardview2)
            val nameCard = findViewById<CardView>(R.id.cardview3)
            val shuffledNumbers = getsuffledLottoNumbers()


            RandomCard.setOnClickListener {
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
                startActivity(intent)
            }
            constellationCard.setOnClickListener {
                startActivity(Intent(this, ConstallationActivity::class.java))
            }
            nameCard.setOnClickListener {
                startActivity(Intent(this, NameActivity::class.java))
            }
        }
    }