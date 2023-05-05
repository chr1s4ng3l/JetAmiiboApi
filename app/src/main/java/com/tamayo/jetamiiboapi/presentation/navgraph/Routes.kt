package com.tamayo.jetamiiboapi.presentation.navgraph

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Details : Routes("details")

}
