package com.saico.weatherforecast.home

import androidx.lifecycle.ViewModel
import com.saico.navigation.Navigator
import com.saico.weatherforecast.home.model.HourlyUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
data class HomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
    private val _uiStateHourly: MutableStateFlow<HourlyUIState> = MutableStateFlow(HourlyUIState())
    val uiStateHourly: StateFlow<HourlyUIState> = _uiStateHourly.asStateFlow()
}