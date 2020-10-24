package com.example.segundoparcial_moviles

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_menu_principal.*

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val opcion1 = opcion("Visualizar Menú", R.drawable.iconomenu)
        val opcion2 = opcion("Mi Perfil", R.drawable.iconoperfil)
        val opcion3 = opcion("Llamanos", R.drawable.iconotelefono)
        val opcion4 = opcion("Escribenos por Whatsapp", R.drawable.iconowhatsapp)
        val opcion5 = opcion("Visita Nuestra Sede", R.drawable.iconomapa)
        val opcion6 = opcion("Siguenos en Facebook", R.drawable.iconofacebook)
        val opcion7 = opcion("Acerca de Esta Aplicacion", R.drawable.iconoinformacion)

        val listaOpciones = listOf(opcion1, opcion2, opcion3,opcion4,opcion5,opcion6,opcion7)

        val adapter = opcionAdapter(this, listaOpciones)

        lvMenu.adapter = adapter

        var intento:Intent

        lvMenu.setOnItemClickListener { parent, view, position, id ->
            if(position==6){
                intento = Intent(this,Informacion::class.java)
                startActivity(intento)
            }
            else if(position==5){
                intento = Intent(this,paginaFacebook::class.java)
                startActivity(intento)
            }
            else if(position==4){
                intento = Intent(this,MapsActivity::class.java)
                startActivity(intento)
            }
            else if(position==3){
                val sendIntent: Intent = Intent()
                val action = sendIntent.setAction(Intent.ACTION_VIEW)
                val urlWhatsapp : String = "whatsapp://send?phone={$573164120502}&text=quihubo, me va a mandar el pedido o no!"
                sendIntent.setPackage("com.whatsapp")
                sendIntent.setData(Uri.parse(urlWhatsapp))
                startActivity(sendIntent)
            }
            else if(position==2){
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:3164120502")
                if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(intent)
                }
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),111)
            }
            else if(position==1){
                intento = Intent(this,Perfil::class.java)
                startActivity(intento)
            }

            else{
                Toast.makeText(this,"FUNCION NO IMPLEMENTADA",Toast.LENGTH_SHORT).show()
            }



            //val intent = Intent(this,MainActivity::class.java)
            //startActivity(intent)

        }
    }
}