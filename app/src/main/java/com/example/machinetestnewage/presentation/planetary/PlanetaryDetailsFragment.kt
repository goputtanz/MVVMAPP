package com.example.machinetestnewage.presentation.planetary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.FragmentPlanetaryDetailsBinding


class PlanetaryDetailsFragment : Fragment(R.layout.fragment_planetary_details) {
    private lateinit var binding: FragmentPlanetaryDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlanetaryDetailsBinding.bind(view)

    }
}