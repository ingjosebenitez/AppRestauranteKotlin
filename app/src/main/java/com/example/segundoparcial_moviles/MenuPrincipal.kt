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
//se instancia cada objeto que conforma el menu de obciones
        val opcion1 = opcion("Visualizar Menú", R.drawable.iconomenu)
        val opcion2 = opcion("Mi Perfil", R.drawable.iconoperfil)
        val opcion3 = opcion("Llamanos", R.drawable.iconotelefono)
        val opcion4 = opcion("Escribenos por Whatsapp", R.drawable.iconowhatsapp)
        val opcion5 = opcion("Visita Nuestra Sede", R.drawable.iconomapa)
        val opcion6 = opcion("Siguenos en Facebook", R.drawable.iconofacebook)
        val opcion7 = opcion("Acerca de Esta Aplicacion", R.drawable.iconoinformacion)
//se enlistan todos los objetos y se adaptan para entregar al listview
        val listaOpciones = listOf(opcion1, opcion2, opcion3,opcion4,opcion5,opcion6,opcion7)

        val adapter = opcionAdapter(this, listaOpciones)

        lvMenu.adapter = adapter

        var intento:Intent
//queda en espera el listview a que se pulse alguna parte de la lista
        //dependiendo de la opcion va a irse a una actividad distinta
        lvMenu.setOnItemClickListener { parent, view, position, id ->
            if(position==6){
                intento = Intent(this,Informacion::class.java)//se va a activity informacion
                startActivity(intento)
            }
            else if(position==5){
                intento = Intent(this,paginaFacebook::class.java)//se va a activity pagina facebook
                startActivity(intento)
            }
            else if(position==4){
                intento = Intent(this,MapsActivity::class.java)
                startActivity(intento)
            }
            //para esta opcion se usa la API de whatsapp, enviando un GET con el numero telefonico y el mensaje a mostrar...
            else if(position==3){
                val sendIntent: Intent = Intent()
                val action = sendIntent.setAction(Intent.ACTION_VIEW)
                val urlWhatsapp : String = "whatsapp://send?phone={$573164120502}&text=quihubo, me va a mandar el pedido o no!"
                sendIntent.setPackage("com.whatsapp")
                sendIntent.setData(Uri.parse(urlWhatsapp))
                startActivity(sendIntent)
            }
            /*
            en esta posicion se encuentra la realizacion de la llamada
            consiste en entregar el numero celular al intent e iniciar la actividad ACTION_CALL
            para esto se deben pedir los permisos correspondientes... sino se cerrará la app
             */
            else if(position==2){
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:3164120502")
                if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(intent)
                }
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),111)
            }
            else if(position==1){
                intento = Intent(this,Perfil::class.java)// se va a activity perfil
                startActivity(intento)
            }
            else if(position==0){
                intento = Intent(this,Categorias::class.java)
                startActivity(intento)
            }
            else{
                Toast.makeText(this,"FUNCION NO IMPLEMENTADA",Toast.LENGTH_SHORT).show()
            }


        }
    }
}