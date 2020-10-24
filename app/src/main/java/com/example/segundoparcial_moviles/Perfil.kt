package com.example.segundoparcial_moviles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_perfil.*

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        etNombre1.setText(preferencias.getString("nombreUsuario", ""))
        etApellido1.setText(preferencias.getString("apellidoUsuario", ""))
        etTelefono1.setText(preferencias.getString("telefonoUsuario", ""))
        etDireccion1.setText(preferencias.getString("direccionUsuario", ""))

        btnGuardar.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("nombreUsuario", etNombre1.text.toString())
            editor.putString("apellidoUsuario", etApellido1.text.toString())
            editor.putString("telefonoUsuario", etTelefono1.text.toString())
            editor.putString("direccionUsuario", etDireccion1.text.toString())
            Toast.makeText(applicationContext,"Datos Almacenados Correctamente",Toast.LENGTH_SHORT).show()
            editor.commit()
            finish()
        }

    }
}