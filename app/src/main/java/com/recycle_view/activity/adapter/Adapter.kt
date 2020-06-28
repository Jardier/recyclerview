package com.recycle_view.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recycle_view.R
import com.recycle_view.activity.model.Filme

class Adapter(val filmes: List<Filme>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                                 .inflate(R.layout.adapter_lista, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  filmes.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val filme = filmes[position];
        holder.titulo.text  = filme.titulo;
        holder.genero.text  = filme.genero;
        holder.ano.text     = filme.ano;
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo  : TextView = itemView.findViewById(R.id.tvTitulo);
        val ano     : TextView = itemView.findViewById(R.id.tvAno);
        val genero  : TextView = itemView.findViewById(R.id.tvGenero);
    }
}