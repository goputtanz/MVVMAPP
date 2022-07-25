package com.example.machinetestnewage.presentation.planetaryDetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.FragmentPlanetaryDetailsBinding
import com.example.machinetestnewage.domain.model.PlanetaryData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PlanetaryDetailsFragment : Fragment(R.layout.fragment_planetary_details) {
    private lateinit var binding: FragmentPlanetaryDetailsBinding
    private val args by navArgs<PlanetaryDetailsFragmentArgs>()
    private val viewModel by viewModels<PlanetaryDetailsViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlanetaryDetailsBinding.bind(view)
        defaultSetUp()
        observePlanetaryDetailsState()

    }

    private fun defaultSetUp() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observePlanetaryDetailsState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.planetaryDetailsUiState.collectLatest {
                    handleSuccess(it.success)
                    handleError(it.error)
                    handleLoading(it.loading)
                }
            }
        }

    }

    private fun handleLoading(loading: Boolean) {
        if (loading) {
            binding.detailsScrollView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.detailsScrollView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun handleError(error: String) {
        if (!error.isNullOrBlank()) {
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSuccess(planetaryData: PlanetaryData?) {
        with(binding) {
            imageDetails.load(planetaryData?.hdurl) {
                placeholder(R.drawable.image_placeholder)
            }
            detailsSubTitle.setText(planetaryData?.title)
            dateText.setText(planetaryData?.date)
            explanationText.setText(planetaryData?.explanation)
        }
    }


}