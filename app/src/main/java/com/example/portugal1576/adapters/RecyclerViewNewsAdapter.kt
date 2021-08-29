package com.example.portugal1576.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.portugal1576.databinding.ItemImageBinding
import com.example.portugal1576.databinding.ItemImageSliderBinding
import com.example.portugal1576.databinding.ItemNewsBinding
import com.example.portugal1576.model.News

class RecyclerViewNewsAdapter(val callback: (news: News) -> Unit) :
    PagedListAdapter<News, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR: DiffUtil.ItemCallback<News> =
            object : DiffUtil.ItemCallback<News>() {
                override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                    return oldItem.time == newItem.time
                }
            }
    }

    val viewType1 = 1
    val viewType2 = 2
    var hotNews: MutableList<News> = emptyList<News>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder1(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(position: Int) {
            binding.news = getItem(position)
            binding.root.setOnClickListener {
                getItem(position)?.let { it1 -> callback.invoke(it1) }
            }
        }

    }

    inner class ViewHolder2(binding: ItemImageSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        var adapter = SliderAdapterExample(binding.root.context)


        fun bind(position: Int) {

            adapter.listNews = hotNews
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


        if (getItem(position)?.viewType == viewType1) {

            (holder as ViewHolder1).bind(position)
        } else {
            (holder as ViewHolder2).bind(position)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewType?: 1
    }
}
