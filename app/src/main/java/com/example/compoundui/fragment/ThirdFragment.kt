package com.example.compoundui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.compoundui.R
import com.example.compoundui.adapter.OtherAdapter
import com.example.compoundui.model.Label


class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv_other = view.findViewById<RecyclerView>(R.id.rv_other)
        val list: ArrayList<Label> = arrayListOf(
            Label("第一事項"),
            Label("第二事項"),
            Label("第三事項"),
            Label("第四事項"),
            Label("第五事項"),
            Label("第六事項"),
            Label("第七事項")
        )

        val otherAdapter = OtherAdapter(list)
        rv_other.apply {
            adapter = otherAdapter
            layoutManager = LinearLayoutManager(view.context)
        }
    }
}