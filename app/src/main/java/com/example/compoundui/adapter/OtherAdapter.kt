package com.example.compoundui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compoundui.R
import com.example.compoundui.model.Label

class OtherAdapter(var list: ArrayList<Label>) :
    RecyclerView.Adapter<OtherAdapter.OtherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_other, parent, false)
        return OtherViewHolder(view)
    }

    override fun onBindViewHolder(holder: OtherViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val other = itemView.findViewById<TextView>(R.id.txt_other)

        fun bind(lab: Label) {
            other.text = lab.tag
        }
    }
}