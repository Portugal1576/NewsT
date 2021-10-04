package com.example.portugal1576.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.adapters.ViewPagerAdapter
import com.example.portugal1576.databinding.ActivityMainBinding
import com.example.portugal1576.ui.fragments.FavouritesFragment
import com.example.portugal1576.ui.fragments.VideoFragment
import com.example.portugal1576.ui.fragments.news.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // 1. Подключаем binding
    private val binding: ActivityMainBinding by viewBinding()

    private val adapterRV by lazy {
        ViewPagerAdapter(this).apply {
            listString = listOf("NEWS", "VIDEO", "FAVOURITES").toMutableList()
            listFragment =
                listOf(NewsFragment(), VideoFragment(), FavouritesFragment()).toMutableList()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() = with(binding) {

        with(pagger) {
            adapter = adapterRV
            isUserInputEnabled = false
        }

        TabLayoutMediator(tabBar, pagger) { tab, position ->
            tab.text = adapterRV.listString[position]
        }.attach()

    }

}