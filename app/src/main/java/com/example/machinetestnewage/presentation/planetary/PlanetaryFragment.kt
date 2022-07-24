package com.example.machinetestnewage.presentation.planetary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.FragmentPlanetaryBinding


class PlanetaryFragment : Fragment(R.layout.fragment_planetary) {

    private lateinit var binding: FragmentPlanetaryBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlanetaryBinding.bind(view)

    }
}