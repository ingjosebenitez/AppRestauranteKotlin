package com.example.segundoparcial_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                val intento1 = Intent(applicationContext, MenuPrincipal::class.java)
                startActivity(intento1)
                finish()
            }

            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()

    }


















}