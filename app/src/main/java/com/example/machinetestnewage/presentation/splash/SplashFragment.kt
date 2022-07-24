package com.example.machinetestnewage.presentation.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding:FragmentSplashBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            delay(2000L)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToPlanetaryFragment())
        }
    }

}