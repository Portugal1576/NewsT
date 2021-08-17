package com.example.portugal1576.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

class BidingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("app:img")
        fun loadImage(img: ImageView, url: String?){
            if (!url.isNullOrBlank())
            img.load(url)
            else img.visibility = View.GONE

        }
    }
}