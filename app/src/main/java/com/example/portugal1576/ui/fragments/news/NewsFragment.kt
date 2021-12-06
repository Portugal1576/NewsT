package com.example.portugal1576.ui.fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.adapters.RecyclerViewNewsAdapter
import com.example.portugal1576.databinding.FragmentNewsBinding
import com.example.portugal1576.model.News
import com.example.portugal1576.model.Status

class NewsFragment : Fragment(R.layout.fragment_news) {

    private val binding: FragmentNewsBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel: NewsViewModel by viewModels()

    private val adapterRV = RecyclerViewNewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initObs()
        initListNews()


        return binding.root
    }

    private fun initObs() {
        viewModel.status.observe(viewLifecycleOwner, {
            when (it) {
                Status.SUCCESS -> {

                    val list = viewModel.list.toMutableList()
                    val listImage = mutableListOf<News>()
                    list.add(0, News("", "", "", "", "", "", 2))

                    for (i in 1 until list.size) {
                        if (list[i].top == "0" && list[i].img != null) listImage.add(list[i])
                    }
                    adapterRV.hotNews = listImage
                    adapterRV.listNews = list

                }
            }
        })

        viewModel.status2.observe(viewLifecycleOwner, {
            when (it) {
                Status.SUCCESS -> with(adapterRV) {
                    listNews.addAll(viewModel.list)
                    notifyDataSetChanged()
                    notifyItemRangeInserted(0, adapterRV.listNews.size)
                }
            }
        })
    }

    private fun initListNews() = with(binding.listNews) {

        layoutManager = LinearLayoutManager(context)
        adapter = adapterRV


        addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!binding.listNews.canScrollVertically(1) && dy != 0) viewModel.onScrolled()

            }

        })
    }

}