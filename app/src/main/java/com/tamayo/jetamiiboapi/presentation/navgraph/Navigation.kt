package com.tamayo.jetamiiboapi.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tamayo.jetamiiboapi.presentation.screens.DetailsScreen
import com.tamayo.jetamiiboapi.presentation.screens.HomeScreen
import com.tamayo.jetamiiboapi.presentation.viewmodel.ViewModelClass

@Composable
fun Navigation(vm: ViewModelClass) {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(vm = vm, navController = navigationController)
        }
        composable(Routes.Details.route) {
            DetailsScreen(vm)
        }

    }
}
