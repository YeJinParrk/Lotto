package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import java.util.*


fun getRandomLottoNumber ():Int{
    return Random().nextInt(45)+1
}

/*fun getRandomLottoNumbers (): MutableList<Int> {
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
    }*/

fun getRandomLottoNumbers(): MutableList<Int> {

    val lottoNumbers = mutableListOf<Int>()

    for (i in 1..6) {
        var number = 0
        do {
            number = getRandomLottoNumber()
        } while (lottoNumbers.contains(number))
        lottoNumbers.add(number)
    }
    return lottoNumbers
}

fun getShuffledLottoNumbers () : MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for (number in 1..45) {
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()

    return lottoNumbers.subList(0, 6)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val randomCard = findViewById<CardView>(R.id.cardview1)
        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            //intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
        }

        val constellationCard = findViewById<CardView>(R.id.cardview2)
        constellationCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))

        }

        val nameCard = findViewById<CardView>(R.id.cardview3)
        nameCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }
    }
}