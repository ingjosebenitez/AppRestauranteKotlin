package com.example.segundoparcial_moviles

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_perfil.*
import kotlinx.android.synthetic.main.activity_vista_producto_completo.*
import kotlinx.android.synthetic.main.activity_vista_producto_completo.etNombre1

class VistaProductoCompleto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_producto_completo)

        val bundle = intent.extras
        val tipo = bundle?.getString("tipo")
        val nombre = bundle?.getString("nombre")
        val imagen = bundle?.getInt("imagen")
        val precio = bundle?.getInt("precio")

        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        val nombreUsuario = preferencias.getString("nombreUsuario", "")
        val apellidoUsuario = preferencias.getString("apellidoUsuario", "")
        val telefonoUsuario = preferencias.getString("telefonoUsuario", "")
        val direccionUsuario = preferencias.getString("direccionUsuario", "")

        etNombre1.setText(tipo+" - "+nombre)
        etPrecio1.setText(precio.toString())
        if (imagen != null) {
            ivProducto1.setImageResource(imagen)
        }

        btnPedir.setOnClickListener {
            val numero = tvNumero1.text.toString().toInt()
            val total = numero* precio!!
            val mensaje = "Hola Don Pepito soy ${nombreUsuario} ${apellidoUsuario}, quisiera pedir lo siguiente:\n${numero} x "+tipo+" : "+nombre+"\nEl total es:${total}\nMi Dirección es ${direccionUsuario}\nMi Telefono es ${telefonoUsuario}\n GRACIAS!"

            val sendIntent: Intent = Intent()
            val urlWhatsapp : String = "whatsapp://send?phone={$573164120502}&text="+mensaje
            sendIntent.setPackage("com.whatsapp")
            sendIntent.setData(Uri.parse(urlWhatsapp))
            startActivity(sendIntent)

        }

    }
}






