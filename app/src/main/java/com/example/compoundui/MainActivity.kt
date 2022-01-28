package com.example.compoundui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.compoundui.adapter.HomeAdapter
import com.example.compoundui.fragment.FirstFragment
import com.example.compoundui.fragment.SecondFragment
import com.example.compoundui.fragment.ThirdFragment
import com.example.compoundui.model.First
import com.example.compoundui.model.Label
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_home)

        val homeAdapter = HomeAdapter()

        recyclerView.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}