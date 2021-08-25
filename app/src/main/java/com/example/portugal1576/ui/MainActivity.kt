package com.example.portugal1576.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.adapters.ViewPagerAdapter
import com.example.portugal1576.databinding.ActivityMainBinding
import com.example.portugal1576.ui.fragments.FavouritesFragment
import com.example.portugal1576.ui.fragments.news.NewsFragment
import com.example.portugal1576.ui.fragments.VideoFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // 1. Подключаем binding
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewPager()

        // Log.d("MyLog", "")
    }

    fun setupViewPager() {
        val adapter = ViewPagerAdapter(this)
        adapter.listString = listOf<String>("NEWS","VIDEO", "FAVOURITES").toMutableList()
        adapter.listFragment =
            listOf<Fragment>(NewsFragment(), VideoFragment(), FavouritesFragment()).toMutableList()
        // установили адаптер для ViewPagger
        binding.pagger.adapter = adapter
        binding.pagger.isUserInputEnabled = false

        // Этот код связывает   pager c tab layaut и возвражает таб и позицию
        TabLayoutMediator(binding.tabBar, binding.pagger) { tab, position ->
            tab.text = adapter.listString[position]
        }.attach()

    }
}