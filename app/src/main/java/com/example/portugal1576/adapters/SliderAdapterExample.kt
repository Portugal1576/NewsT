package com.example.portugal1576.adapters


import android.content.Context
import android.graphics.Color

import android.widget.TextView

import com.smarteist.autoimageslider.SliderViewAdapter

import android.widget.Toast

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.example.portugal1576.R
import com.example.portugal1576.model.News


class SliderAdapterExample(context: Context) :
    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {
    private val context: Context

    var listNews: MutableList<News> = emptyList<News>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.item_image, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem = listNews[position]
        viewHolder.imageView.load(sliderItem.img)
        viewHolder.title.text = sliderItem.title
        viewHolder.url_news.text = sliderItem.click_url
        viewHolder.time_news.text = sliderItem.time



    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return listNews.size
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.title)
        val url_news = itemView.findViewById<TextView>(R.id.url_news)
        val time_news = itemView.findViewById<TextView>(R.id.time_news)

    }

    init {
        this.context = context
    }
}