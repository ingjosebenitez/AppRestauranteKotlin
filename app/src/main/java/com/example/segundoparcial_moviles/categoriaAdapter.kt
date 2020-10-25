package com.example.segundoparcial_moviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_categoria.view.*

class categoriaAdapter(private val mContext: Context, private val listaCategorias: List<Categoria>) : ArrayAdapter<Categoria>(mContext, 0, listaCategorias) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_categoria, parent, false)

        val categoria_ = listaCategorias[position]

        layout.tvTituloProducto1.text = categoria_.nombre
        layout.ivLogo1.setImageResource(categoria_.imagen)

        return layout
    }
}

/*
el adaptador funciona basicamente recolectando todos los objetos
que se quieren mostrar en el listView, manejando todo como listas...
de aqui lo que se hace es crear un frame pequeño (item_categoria)
y armarlo con la presentacion de nombre, imagen y otros
para luego pegarla en el listview y ahorras tiempo de diseño
 */