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
import com.example.portugal1576.databinding.FragmentFavouritesBinding
import com.example.portugal1576.databinding.FragmentNewsBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private val binding: FragmentFavouritesBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.root.setBackgroundColor(Color.BLUE)
        return binding.root
    }
}