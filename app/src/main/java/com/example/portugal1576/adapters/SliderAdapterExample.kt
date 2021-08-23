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
import com.example.portugal1576.R
import com.example.portugal1576.model.News


class SliderAdapterExample(context: Context) :
    SliderViewAdapter<SliderAdapterExample.SliderAdapterVH>() {
    private val context: Context
    private var mSliderItems: MutableList<News> = ArrayList()
    fun renewItems(sliderItems: MutableList<News>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: News) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: News = mSliderItems[position]

    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSliderItems.size
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
    }

    init {
        this.context = context
    }
}