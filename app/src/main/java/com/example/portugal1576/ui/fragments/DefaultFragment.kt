package com.example.portugal1576.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.portugal1576.R
import com.example.portugal1576.databinding.FragmentDefaultBinding

abstract  class DefaultFragment: Fragment(R.layout.fragment_default){
    private val binding: FragmentDefaultBinding by viewBinding(CreateMethod.INFLATE)
    private var color: Int = Color.RED
    private var text = "VIDEO"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.root.setBackgroundColor(color)
        binding.tvVideo.text = text
        return binding.root
    }
    open fun setColor(color: Int){
        this.color = color
    }
    open fun setText(text: String){
        this.text = text
    }

}