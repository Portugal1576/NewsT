package com.example.portugal1576.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

class BidingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("app:img")
        fun loadImage(img: ImageView, url: String){
            img.load(url)

        }
    }
}