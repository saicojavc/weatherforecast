package com.saico.weatherforecast.home.model

data class HourlyUIState(
    val hour: String = "",
    val temp: Int = 0,
    val picPath: String = ""
)
data class FutureModelItem(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)