package com.example.testeaplicativo.model

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testeaplicativo.R
import com.example.testeaplicativo.network.response.CatResponse
import com.example.testeaplicativo.ui.DetalheActivity
import com.example.testeaplicativo.ui.MainActivity
import com.squareup.picasso.Picasso



class CatAdapter(
        var items: List<CatResponse>,
        val listener: MyOnClickListener
        , val position: Int
        )  : RecyclerView.Adapter<CatAdapter.ViewHolder>(){

    //classe interna
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val textViewNome: TextView
        val textViewDescricao: TextView
        val imageView: ImageView


        init {
            //find do custom view
            textViewNome = itemView.findViewById<TextView>(R.id.text_nome)
            textViewDescricao = itemView.findViewById<TextView>(R.id.text_descricao)
            imageView = itemView.findViewById<ImageView>(R.id.imageView)

            //click listener chamado na main activity
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.OnClick(items, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.custom_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size // tamanho da lista de gatos

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //pega a posição de cada gato
        var itemData = items.get(position)

        //carrega as informações de cada gato baseado na posição
        holder.textViewNome.text = itemData.name
        holder.textViewDescricao.text = itemData.temperament
        Picasso.get().load(itemData.image.url).into(holder.imageView)

    }

    //click listener chamado na main activity
    interface MyOnClickListener{
        fun OnClick(items: List<CatResponse>, position: Int)
    }

}




