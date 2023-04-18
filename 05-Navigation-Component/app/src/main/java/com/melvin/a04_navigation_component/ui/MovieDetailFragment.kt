package com.melvin.a04_navigation_component.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.a04_navigation_component.R

class MovieDetailFragment : Fragment() {

    private lateinit var returnButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListeners()
    }

    private fun bind() {
        returnButton = view?.findViewById(R.id.return_button_form2) as FloatingActionButton
    }

    private fun addListeners() {
        returnButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_movieDetailFragment_to_movieContainerFragment)
        }
    }
}