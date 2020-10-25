package com.example.segundoparcial_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categorias.*
import kotlinx.android.synthetic.main.activity_menu_principal.*

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

        lvCategoria.adapter = adapter
    }
}