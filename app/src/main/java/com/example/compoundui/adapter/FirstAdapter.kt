package com.example.compoundui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compoundui.R
import com.example.compoundui.model.Label

class FirstAdapter(var list: ArrayList<Label>) : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_first, parent, false)
        return FirstViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val label = itemView.findViewById<TextView>(R.id.txt_label)
        fun bind(lab: Label) {

            label.text = lab.tag
        }
    }
}