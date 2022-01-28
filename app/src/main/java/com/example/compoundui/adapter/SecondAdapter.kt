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
        holder.bind(Tag.lab1[position])
    }

    override fun getItemCount(): Int = Tag.lab1.size

    inner class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val label = itemView.findViewById<TextView>(R.id.txt_label)
        fun bind(lab: Content.Label1) {

            label.text = lab.tag
        }
    }
}