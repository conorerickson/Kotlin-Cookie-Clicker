package com.conore.cookie_clicker

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private var currentScore = 0
private var numOfClickers = 0
private var scope = MainScope()
private var job: Job? = null
private var isFirstClick : Boolean = true
private var cost : Int = 10

    class MainActivity : AppCompatActivity() {
        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val tvAutoClickers: TextView = findViewById(R.id.tvAutoClickers)
            val tvScore: TextView = findViewById(R.id.tvScore)
            val ibCookie: ImageButton = findViewById(R.id.ibCookie)
            val btnBuy: TextView = findViewById(R.id.btnBuy)
            val price: TextView = findViewById(R.id.tvPrice)

            fun autoClick() {
                currentScore += numOfClickers
                tvScore.text = "You have $currentScore Cookies!"
            }

            fun startUpdates() {
                job = scope.launch {
                    tvAutoClickers.text = "You have $numOfClickers Auto-Clickers!"
                    price.text = "An Auto-Clicker costs $cost Cookies"
                    while (true) {
                        autoClick()
                        delay(1000)
                    }
                }
            }

            ibCookie.setOnClickListener {
                currentScore++
                tvScore.text = "You have $currentScore Cookies!"
            }

            btnBuy.setOnClickListener {
                buy()
                startUpdates()
            }
        }

        private fun buy() {
            if(currentScore >= cost) {
                currentScore -= cost
                numOfClickers ++
                cost *= 2
            } else {
                Toast.makeText(this, "Not Enough Cookies!", Toast.LENGTH_SHORT).show()
                return
            }
        }
    }
