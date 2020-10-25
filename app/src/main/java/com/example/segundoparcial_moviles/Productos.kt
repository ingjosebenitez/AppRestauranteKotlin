package com.example.segundoparcial_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_productos.*

class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val bundle = intent.extras
        val tipo = bundle?.getString("tipo")
        var intento: Intent
        var producto1 = Producto("",R.drawable.hamburguesa1,0)
        var producto2 = Producto("",R.drawable.hamburguesa1,0)
        var producto3 = Producto("",R.drawable.hamburguesa1,0)

        if(tipo.equals("hamburguesa")){
            producto1 = Producto("Dos Pisos", R.drawable.hamburguesa1,5000)
            producto2 = Producto("Sencilla", R.drawable.hamburguesa2,6000)
            producto3 = Producto("CON TODA!", R.drawable.hamburguesa3,7000)
            val listaProductos = listOf(producto1,producto2,producto3)
            val adapter = productoAdapter(this, listaProductos)
            lvProductos.adapter = adapter
        }
        if(tipo.equals("perro")){
            producto1 = Producto("Extendido", R.drawable.perro1,12000)
            producto2 = Producto("Monstruo", R.drawable.perro2,15000)
            producto3 = Producto("Sencillo!", R.drawable.perro3,8000)
            val listaProductos = listOf(producto1,producto2,producto3)
            val adapter = productoAdapter(this, listaProductos)
            lvProductos.adapter = adapter
        }
        if(tipo.equals("papas")){
            producto1 = Producto("Elegantes", R.drawable.papas1,5000)
            producto2 = Producto("Ensalsadas", R.drawable.papas2,11000)
            val listaProductos = listOf(producto1,producto2)
            val adapter = productoAdapter(this, listaProductos)
            lvProductos.adapter = adapter
        }
        if(tipo.equals("bebida")){
            producto1 = Producto("Cerveza", R.drawable.bebida1,2500)
            producto2 = Producto("Gaseosa", R.drawable.bebida2,1000)
            val listaProductos = listOf(producto1,producto2)
            val adapter = productoAdapter(this, listaProductos)
            lvProductos.adapter = adapter
        }
        lvProductos.setOnItemClickListener { parent, view, position, id ->
            if(position==0){
                intento = Intent(this,VistaProductoCompleto::class.java)
                intento.putExtra("tipo", tipo)
                intento.putExtra("nombre", producto1.nombre)
                intento.putExtra("imagen", producto1.imagen)
                intento.putExtra("precio", producto1.precio)
                startActivity(intento)
            }
            if(position==1){
                intento = Intent(this,VistaProductoCompleto::class.java)
                intento.putExtra("tipo", tipo)
                intento.putExtra("nombre", producto2.nombre)
                intento.putExtra("imagen", producto2.imagen)
                intento.putExtra("precio", producto2.precio)
                startActivity(intento)
            }
            if(position==2){
                intento = Intent(this,VistaProductoCompleto::class.java)
                intento.putExtra("tipo", tipo)
                intento.putExtra("nombre", producto3.nombre)
                intento.putExtra("imagen", producto3.imagen)
                intento.putExtra("precio", producto3.precio)
                startActivity(intento)
            }
        }





    }
}