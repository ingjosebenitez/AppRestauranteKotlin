package com.example.segundoparcial_moviles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_menu.view.*

class opcionAdapter(private val mContext: Context, private val listaOpciones: List<opcion>) : ArrayAdapter<opcion>(mContext, 0, listaOpciones) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_menu, parent, false)

        val opcion_ = listaOpciones[position]

        layout.tvNombre.text = opcion_.nombre
        layout.ivMenu.setImageResource(opcion_.imagen)

        return layout
    }
}