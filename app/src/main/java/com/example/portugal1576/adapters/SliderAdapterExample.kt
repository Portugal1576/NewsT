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

    var listImage: MutableList<String> = emptyList<String>().toMutableList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.item_image, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem = listImage[position]
        if (sliderItem.isNotEmpty()) viewHolder.imageView.load(sliderItem)



    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return listImage.size
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