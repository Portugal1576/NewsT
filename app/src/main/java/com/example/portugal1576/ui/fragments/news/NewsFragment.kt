package com.example.portugal1576.ui.fragments.news

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.adapters.RecyclerViewNewsAdapter
import com.example.portugal1576.databinding.FragmentNewsBinding
import com.example.portugal1576.model.News
import com.example.portugal1576.model.Status

class NewsFragment : Fragment(R.layout.fragment_news) {
    //инициализация viewmodel
    private val viewModel: NewsViewModel by viewModels()
    val adapterRV = RecyclerViewNewsAdapter {
        Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
    }
    private val binding: FragmentNewsBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.status.observe(viewLifecycleOwner, {
            when(it){
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
                Status.EMPTY -> {

                }
                Status.SUCCESS -> {

                    val list = viewModel.list.toMutableList()
                    val listImage = mutableListOf<News>()
                    list.add(0, News("","","","","","", 2))

                    for (i in 1..list.size-1){
                        if (list[i].img !=null)
                        listImage.add(list[i])
                    }
                    adapterRV.hotNews = listImage
                    adapterRV.listNews = list

                }
            }
        })

        binding.listNews.layoutManager = LinearLayoutManager(context)
        binding.listNews.adapter = adapterRV
        binding.root.setBackgroundColor(Color.BLACK)
        return binding.root
    }
}