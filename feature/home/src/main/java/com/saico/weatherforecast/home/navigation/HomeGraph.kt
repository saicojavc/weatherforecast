package com.saico.weatherforecast.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.navigation.routes.home.HomeRoute
import com.saico.weatherforecast.home.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation(
        startDestination = HomeRoute.HomeScreenRoute.route,
        route = HomeRoute.RootRoute.route
    ){
        composable(route = HomeRoute.HomeScreenRoute.route) {
            HomeScreen(navController)
        }
    }
}