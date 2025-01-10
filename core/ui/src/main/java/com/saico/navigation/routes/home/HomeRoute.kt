package com.saico.navigation.routes.home

import com.saico.navigation.routes.Route

sealed interface HomeRoute : Route {

    data object RootRoute : HomeRoute{
        override val analyticsTag = "home_root"
        override val route = "home"
    }
    data object HomeScreenRoute : HomeRoute{
        override val analyticsTag = "home_screen-flow"
        override val route = "home/home-screen"
    }
}