package com.conore.cookie_clicker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

private var currentScore = 0
private var numOfClickers = 0


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvAutoClickers : TextView = findViewById(R.id.tvAutoClickers)
        val tvScore : TextView = findViewById(R.id.tvScore)
        val ibCookie : ImageButton = findViewById(R.id.ibCookie)
        val btnBuy : TextView = findViewById(R.id.btnBuy)

        ibCookie.setOnClickListener {
            currentScore ++
            tvScore.text = "You have $currentScore Cookies!"

        }
        btnBuy.setOnClickListener {
            numOfClickers ++
            tvAutoClickers.text = "You have $numOfClickers Auto-Clickers"
            }
        }
}