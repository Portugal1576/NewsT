package com.example.portugal1576.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.portugal1576.databinding.ItemNewsBinding
import com.example.portugal1576.model.News

class RecyclerViewNewsAdapter(val callback: (news: News) -> Unit): RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder>() {
    var listNews: MutableList<News> = emptyList<News>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    class ViewHolder(binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root){
        val binding = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.news = listNews[position]
        holder.binding.root.setOnClickListener {
            callback.invoke(listNews[position])
        }

    }

    override fun getItemCount(): Int = listNews.size

}
