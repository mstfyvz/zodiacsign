package com.zodiacsign.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zodiacsign.app.ui.screens.LoginScreen

@Composable
fun LoginNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItem.LoginScreenNavigationItem.route) {
        composable(NavigationItem.LoginScreenNavigationItem.route) {
            LoginScreen()
        }
    }

}