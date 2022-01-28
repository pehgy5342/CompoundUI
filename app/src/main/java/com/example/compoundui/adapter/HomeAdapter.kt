package com.example.compoundui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.compoundui.R
import com.example.compoundui.fragment.FirstFragment
import com.example.compoundui.fragment.SecondFragment
import com.example.compoundui.fragment.ThirdFragment
import com.example.compoundui.model.Tag
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_RV_1 = 1
        private const val VIEW_PAGER = 2
        private const val VIEW_RV_2 = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_RV_1
            1 -> VIEW_PAGER
            2 -> VIEW_RV_2
            else -> throw IllegalStateException("Unknown view type at position $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            VIEW_RV_1 -> {
                val rv1_view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_rv_first, parent, false)
                FirstViewHolder(rv1_view)
            }
            VIEW_PAGER -> {
                val pager_view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view_pager, parent, false)
                TagViewHolder(pager_view)
            }
            VIEW_RV_2 -> {
                val rv2_view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_rv_second, parent, false)
                SecondViewHolder(rv2_view)
            }
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FirstViewHolder -> {
                val title = holder.itemView.findViewById<TextView>(R.id.txt_title)
                title.text = Tag.title[position]
                holder.bind()

            }
            is TagViewHolder -> {
                val title = holder.itemView.findViewById<TextView>(R.id.txt_title)
                title.text = Tag.title[position]
                holder.bind()
            }
            is SecondViewHolder -> {
                val title = holder.itemView.findViewById<TextView>(R.id.txt_title)
                title.text = Tag.title[position]
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int = 3


    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rv1 = itemView.findViewById<RecyclerView>(R.id.rv_first)
        fun bind() {
            val firstAdapter = FirstAdapter()

            rv1.apply {
                adapter = firstAdapter
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }

    class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tabTitle: Array<String> get() = itemView.resources.getStringArray(R.array.tab)
        val tabLayout = itemView.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = itemView.findViewById<ViewPager2>(R.id.viewPager)
        fun bind() {
            viewPager.adapter =
                object : FragmentStateAdapter(itemView.context as FragmentActivity) {
                    override fun getItemCount(): Int = 3

                    override fun createFragment(position: Int): Fragment {
                        return when (position) {
                            0 -> {
                                FirstFragment()
                            }
                            1 -> {
                                SecondFragment()
                            }
                            else -> ThirdFragment()
                        }
                    }
                }

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTitle[position]
            }.attach()
        }
    }

    class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rv2 = itemView.findViewById<RecyclerView>(R.id.rv_second)
        fun bind() {
            val secondAdapter = SecondAdapter()

            rv2.apply {
                adapter = secondAdapter
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }

}


