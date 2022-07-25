package com.example.machinetestnewage.presentation.planetary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetestnewage.app.util.Resource
import com.example.machinetestnewage.domain.model.PlanetaryData
import com.example.machinetestnewage.domain.repository.PlanetaryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetaryViewModel @Inject constructor(
    private val repository: PlanetaryRepository
) : ViewModel() {

    private val _planetaryFragmentUiState = MutableStateFlow(PlanetaryState())
    val planetaryFragmentUiState = _planetaryFragmentUiState.asStateFlow()

    init {
        getPlanetaryDataList()
    }


    private fun getPlanetaryDataList() {
        viewModelScope.launch {
            repository.planetData().collectLatest {
                when (it) {
                    is Resource.Loading -> handleLoading()
                    is Resource.Error -> handleError(it.error)
                    is Resource.Success -> handleSuccess(it.value)
                }
            }
        }

    }

    private fun handleSuccess(value: List<PlanetaryData>) {
        _planetaryFragmentUiState.update { it.copy(loading = false, success = value) }
    }

    private fun handleError(error: String) {
        _planetaryFragmentUiState.update { it.copy(loading = false, error = error) }
    }

    private fun handleLoading() {
        _planetaryFragmentUiState.update { it.copy(loading = true) }
    }


}