package com.example.segundoparcial_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_categorias.*

class Categorias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        val categoria1 = Categoria("Promociones", R.drawable.iconopromociones)
        val categoria2 = Categoria("Hamburguesas", R.drawable.iconohamburguesa)
        val categoria3 = Categoria("Perros Calientes", R.drawable.iconoperrocaliente)
        val categoria4 = Categoria("Papas Fritas", R.drawable.iconopapas)
        val categoria5 = Categoria("Alitas y Costillitas", R.drawable.iconopollo)
        val categoria6 = Categoria("Bebidas", R.drawable.iconobebida)

        val listaCategorias = listOf(categoria1,categoria2,categoria3,categoria4,categoria5,categoria6)
        val adapter = categoriaAdapter(this, listaCategorias)
        lvCategorias.adapter = adapter
        var intento: Intent

        lvCategorias.setOnItemClickListener { parent, view, position, id ->
            if(position==0){
                Toast.makeText(this,"NO HAY PROMOCIONES EN EL MOMENTO!", Toast.LENGTH_SHORT).show()
            }
            if(position==1){
                intento = Intent(this,Productos::class.java)
                intento.putExtra("tipo", "hamburguesa")
                startActivity(intento)
            }
            if(position==2){
                intento = Intent(this,Productos::class.java)
                intento.putExtra("tipo", "perro")
                startActivity(intento)
            }
            if(position==3){
                intento = Intent(this,Productos::class.java)
                intento.putExtra("tipo", "papas")
                startActivity(intento)
            }
            if(position==4){
                Toast.makeText(this,"No hay Existencias",Toast.LENGTH_SHORT).show()
            }
            if(position==5){
                intento = Intent(this,Productos::class.java)
                intento.putExtra("tipo", "bebida")
                startActivity(intento)
            }
        }
    }
}