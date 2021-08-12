package com.example.portugal1576.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.adapters.RecyclerViewNewsAdapter
import com.example.portugal1576.databinding.FragmentNewsBinding
import com.example.portugal1576.model.News

class NewsFragment : Fragment(R.layout.fragment_news) {
    val adapterRV = RecyclerViewNewsAdapter()
    private val binding: FragmentNewsBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapterRV.listNews = listOf(
            News(
                "NEWS",
                "1",
                "http://188.40.167.45:3001/img/test3.jpg",
                "https://lampalampa.net",
                "2 hour ago",
                "0"
            ),
            News(
                "NEWS",
                "1",
                "http://188.40.167.45:3001/img/test4.jpg",
                "https://lampalampa.net",
                "2 hour ago",
                "0"
            )
        ).toMutableList()
        binding.listNews.layoutManager = LinearLayoutManager(context)
        binding.listNews.adapter = adapterRV
        binding.root.setBackgroundColor(Color.BLACK)
        return binding.root
    }
}