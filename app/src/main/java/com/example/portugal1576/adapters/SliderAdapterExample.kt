package com.example.portugal1576.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.portugal1576.databinding.ItemImageBinding
import com.example.portugal1576.model.News
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapterExample :
    SliderViewAdapter<SliderAdapterExample.ViewHolderAdapter>() {

    var listNews: MutableList<News> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup): ViewHolderAdapter {
        return ViewHolderAdapter(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolderAdapter, position: Int) {
        val sliderItem = listNews[position]
        with(viewHolder.binding) {
            imageView.load(sliderItem.img)
            title.text = sliderItem.title
            urlNews.text = sliderItem.click_url
            timeNews.text = sliderItem.time
        }


    }

    override fun getCount(): Int = listNews.size

    inner class ViewHolderAdapter(val binding: ItemImageBinding) : ViewHolder(binding.root)

}