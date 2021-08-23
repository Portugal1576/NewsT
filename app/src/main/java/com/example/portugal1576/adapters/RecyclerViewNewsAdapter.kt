package com.example.portugal1576.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.portugal1576.databinding.ItemImageBinding
import com.example.portugal1576.databinding.ItemImageSliderBinding
import com.example.portugal1576.databinding.ItemNewsBinding
import com.example.portugal1576.model.News

class RecyclerViewNewsAdapter(val callback: (news: News) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val viewType1 = 1
    val viewType2 = 2
    var listImage: MutableList<String> = emptyList<String>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listNews: MutableList<News> = emptyList<News>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder1(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(position: Int) {
            binding.news = listNews[position]
            binding.root.setOnClickListener {
                callback.invoke(listNews[position])
            }
        }

    }

    inner class ViewHolder2(binding: ItemImageSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        var adapter = SliderAdapterExample(binding.root.context)


        fun bind(position: Int) {

            adapter.listImage = listImage
            binding.imageSlider.setSliderAdapter(adapter)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return if (viewType == viewType1) {
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


        if (listNews[position].viewType == viewType1) {

            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind(position)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return listNews[position].viewType
    }

    override fun getItemCount(): Int = listNews.size

}
