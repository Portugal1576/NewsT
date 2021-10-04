package com.example.portugal1576.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portugal1576.databinding.ItemImageSliderBinding
import com.example.portugal1576.databinding.ItemNewsBinding
import com.example.portugal1576.model.News

class RecyclerViewNewsAdapter(val callback: ((news: News) -> Unit)? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var hotNews: MutableList<News> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listNews: MutableList<News> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder1(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(position: Int) {
            binding.news = listNews[position]
            binding.root.setOnClickListener {
                callback?.invoke(listNews[position])
            }
        }

    }

    inner class ViewHolder2(binding: ItemImageSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        var adapter = SliderAdapterExample()


        fun bind() {

            adapter.listNews = hotNews
            binding.imageSlider.setSliderAdapter(adapter)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return if (viewType == 1) {
            ViewHolder1(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            ViewHolder2(
                ItemImageSliderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (listNews[position].viewType == 1) {

            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind()
        }


    }

    override fun getItemViewType(position: Int): Int {
        return listNews[position].viewType
    }

    override fun getItemCount(): Int = listNews.size

}