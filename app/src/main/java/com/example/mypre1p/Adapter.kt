package com.example.mypre1p

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreElem: TextView = view.findViewById(R.id.item_nombre)
        val imageElem: ImageView = view.findViewById(R.id.item_img) // Escudo Imagen
        val estadioElem: TextView = view.findViewById(R.id.item_estadio)
        val apodoElem: TextView = view.findViewById(R.id.item_apodo)
        val banderaElem: ImageView = view.findViewById(R.id.item_bandera) //Bandera Imagen


        fun bind (eqp: Equipo) {
            nombreElem.text=eqp.nombre
            estadioElem.text=eqp.estadio
            apodoElem.text=eqp.apodo

            Glide.with(context).load(eqp.escudo).into(imageElem)

            val image = when(eqp.pais) {
                Pais.URUGUAY -> R.drawable.flaguruguay
                Pais.ARGENTINA -> R.drawable.flagargentina
                Pais.CHILE -> R.drawable.flagchile
                Pais.COLOMBIA -> R.drawable.flagcolombia
                Pais.BRAZIL -> R.drawable.flagbrazil
                else -> R.drawable.flagparaguay
            }

            banderaElem.setImageResource(image)

            view.setOnClickListener() {
                onItemClickListener(eqp)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}