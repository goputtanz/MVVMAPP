package com.example.machinetestnewage.presentation.planetaryDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetestnewage.domain.model.PlanetaryData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetaryDetailsViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _planetaryDetailsUiState = MutableStateFlow(PlanetaryDetailsState())
    val planetaryDetailsUiState = _planetaryDetailsUiState.asStateFlow()


    init {
        getPlanetaryDetails()
    }

    private fun getPlanetaryDetails() {
        viewModelScope.launch {
            _planetaryDetailsUiState.update { it.copy(loading = false) }
            val data = savedStateHandle.get<PlanetaryData>("planetaryData")
            if (data != null) _planetaryDetailsUiState.update {
                it.copy(
                    loading = false,
                    success = data
                )
            } else _planetaryDetailsUiState.update {
                it.copy(
                    loading = false,
                    error = "Cannot load data"
                )
            }
        }
    }

}