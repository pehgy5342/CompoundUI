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
import com.example.compoundui.model.Label
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabTitle: Array<String> get() = resources.getStringArray(R.array.tab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_home)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)


        val labelList: ArrayList<Label> =
            arrayListOf(Label("我是第1個"), Label("我是第2個"), Label("我是第3個"), Label("我是第4個"))

        val homeAdapter = HomeAdapter()

        recyclerView.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        }

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> FirstFragment()
                    1 -> SecondFragment()
                    else -> ThirdFragment()
                }
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        viewPager.setCurrentItem(0, false)
        viewPager.offscreenPageLimit = 2

    }
}