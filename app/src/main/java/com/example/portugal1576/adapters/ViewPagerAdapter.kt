package com.example.portugal1576.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(container: FragmentActivity) : FragmentStateAdapter(container) {

    var listFragment: MutableList<Fragment> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listString: MutableList<String> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position]

}