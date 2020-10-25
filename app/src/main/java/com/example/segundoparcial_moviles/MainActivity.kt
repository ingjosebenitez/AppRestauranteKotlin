package com.example.segundoparcial_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
este es un contador en decenso, se usa para congelar pantalla 3 segundos
y alcanzar a mostrar el logo del restaurante que es un .gif
al finalizar el tiempo se va a MenuPrincipal y destruye esta actividad
para que no vuelva a entrar aca
 */
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