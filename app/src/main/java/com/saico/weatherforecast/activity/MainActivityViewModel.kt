package com.saico.weatherforecast.activity

import androidx.lifecycle.ViewModel
import com.saico.navigation.routes.home.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(): ViewModel(){
    var firstScreen = HomeRoute.RootRoute.route
}