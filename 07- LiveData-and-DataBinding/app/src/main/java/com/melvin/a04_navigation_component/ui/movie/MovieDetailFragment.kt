package com.melvin.a04_navigation_component.ui.movie


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.a04_navigation_component.R
import com.melvin.a04_navigation_component.databinding.FragmentFormAddMovieBinding
import com.melvin.a04_navigation_component.databinding.FragmentMovieContainerBinding
import com.melvin.a04_navigation_component.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}