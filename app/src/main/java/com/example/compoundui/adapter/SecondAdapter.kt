package com.example.compoundui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compoundui.R
import com.example.compoundui.model.Content
import com.example.compoundui.model.Tag

class SecondAdapter() :
    RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_second, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.bind(Tag.lab2[position])
    }

    override fun getItemCount(): Int = Tag.lab2.size

    inner class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.txt_title)
        val id = itemView.findViewById<TextView>(R.id.txt_id)
        val name = itemView.findViewById<TextView>(R.id.txt_name)

        fun bind(lab: Content.Label2) {
            title.text = lab.title
            id.text = lab.id
            name.text = lab.name
        }
    }
}