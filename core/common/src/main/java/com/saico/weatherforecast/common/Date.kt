package com.saico.weatherforecast.common

fun getCurrentTime(format: String = "HH:mm:ss"): String {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        // Usar LocalDateTime para API 26+
        val currentDateTime = java.time.LocalDateTime.now()
        val formatter = java.time.format.DateTimeFormatter.ofPattern(format)
        currentDateTime.format(formatter)
    } else {
        // Usar Calendar para versiones anteriores
        val calendar = java.util.Calendar.getInstance()
        val dateFormat = java.text.SimpleDateFormat(format, java.util.Locale.getDefault())
        dateFormat.format(calendar.time)
    }
}
