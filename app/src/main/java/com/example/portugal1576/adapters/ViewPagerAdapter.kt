package com.example.portugal1576.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(container: FragmentActivity): FragmentStateAdapter(container) {
    var listFragment: MutableList<Fragment> = emptyList<Fragment>().toMutableList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    var listString: MutableList<String> = emptyList<String>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}