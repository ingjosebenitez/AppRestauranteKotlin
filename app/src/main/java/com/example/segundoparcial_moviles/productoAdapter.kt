package com.example.segundoparcial_moviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_producto.view.*

class productoAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto_ = listaProductos[position]
        layout.tvTituloProducto1.text = producto_.nombre
        layout.tvPrecio1.text = "$"+producto_.precio.toString()
        layout.ivLogo1.setImageResource(producto_.imagen)

        return layout
    }
}