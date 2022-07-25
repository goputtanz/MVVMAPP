package com.example.machinetestnewage.presentation.planetary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.machinetestnewage.R
import com.example.machinetestnewage.databinding.FragmentPlanetaryBinding
import com.example.machinetestnewage.domain.model.PlanetaryData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PlanetaryFragment : Fragment(R.layout.fragment_planetary),
    PlanetaryAdapter.PlanetaryItemClick {

    private val viewModel by viewModels<PlanetaryViewModel>()
    private lateinit var planetaryAdapter: PlanetaryAdapter
    private lateinit var binding: FragmentPlanetaryBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlanetaryBinding.bind(view)

        defaultSetup()
        setUpRecyclerView()
        observePlanetaryUiState()

    }

    private fun defaultSetup() {
        planetaryAdapter = PlanetaryAdapter(this)
    }

    private fun setUpRecyclerView() {
        binding.planetaryRecyclerView.adapter = planetaryAdapter
    }

    private fun observePlanetaryUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.planetaryFragmentUiState.collectLatest {
                    handleSuccess(it.success)
                    handleFailure(it.error)
                    handleLoading(it.loading)
                }
            }
        }
    }

    private fun handleLoading(loading: Boolean) {
        if (loading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.planetaryRecyclerView.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.planetaryRecyclerView.visibility = View.VISIBLE
        }
    }

    private fun handleFailure(error: String) {
        if (!error.isNullOrBlank()) {
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSuccess(planetaryList: List<PlanetaryData>) {
        planetaryAdapter.submitList(planetaryList)
    }

    override fun onItemClick(item: PlanetaryData) {

    }


}