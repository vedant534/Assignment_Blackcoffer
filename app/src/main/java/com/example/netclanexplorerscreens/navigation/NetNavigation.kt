package com.example.netclanexplorerscreens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netclanexplorerscreens.exploreScreen.ExploreScreen
import com.example.netclanexplorerscreens.refineScreen.RefineScreen

@Composable
fun NetNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NetScreens.ExploreScreen.name
    ) {
        composable(NetScreens.ExploreScreen.name) {
            ExploreScreen(navController = navController)
        }
        composable(NetScreens.RefineScreen.name) {
            RefineScreen(navController = navController)
        }
    }
}
