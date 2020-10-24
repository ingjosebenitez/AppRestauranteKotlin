package com.example.segundoparcial_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import kotlinx.android.synthetic.main.activity_informacion.*

class Informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        tvLink.setMovementMethod(LinkMovementMethod.getInstance()) //instancia el link en la activity
    }
}