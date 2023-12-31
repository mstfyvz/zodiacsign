package com.zodiacsign.app.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zodiacsign.app.R
import com.zodiacsign.app.model.CommentDetailId
import com.zodiacsign.app.model.PlanetDetailId
import com.zodiacsign.app.ui.screens.CommentDetailScreen
import com.zodiacsign.app.ui.screens.CommentScreen
import com.zodiacsign.app.ui.screens.HomeScreen
import com.zodiacsign.app.ui.screens.PlanetDetailScreen
import com.zodiacsign.app.ui.screens.PlanetScreen
import com.zodiacsign.app.ui.screens.ProfileScreen
import com.zodiacsign.app.ui.screens.WeeklyZodiacScreen
import com.zodiacsign.app.ui.screens.ZodiacScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()

    val bottomBarScreens = listOf(
        BottomBarScreen(NavigationItem.HomeScreenNavigationItem, Icons.Outlined.Home),
        BottomBarScreen(
            NavigationItem.PlanetScreenNavigationItem,
            ImageVector.vectorResource(R.drawable.icon_planet)
        ),
        BottomBarScreen(
            NavigationItem.CommentScreenNavigationItem,
            ImageVector.vectorResource(R.drawable.icon_message)
        ),
        BottomBarScreen(NavigationItem.ProfileScreenNavigationItem, Icons.Outlined.Person),
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomBarScreens.forEach { bottomBarScreen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                bottomBarScreen.icon, "",
                                Modifier
                                    .width(24.dp)
                                    .height(24.dp)
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == bottomBarScreen.screen.route } == true,
                        onClick = {
                            navController.navigate(bottomBarScreen.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.HomeScreenNavigationItem.route,
            Modifier.padding(paddingValues)
        ) {
            composable(NavigationItem.HomeScreenNavigationItem.route) {
                HomeScreen(navController)
            }
            composable(NavigationItem.ZodiacScreenNavigationItem.route) {
                ZodiacScreen()
            }
            composable(NavigationItem.WeeklyZodiacScreenNavigationItem.route) {
                WeeklyZodiacScreen()
            }
            composable(NavigationItem.PlanetScreenNavigationItem.route) {
                PlanetScreen(navController)
            }
            composable(
                NavigationItem.PlanetDetailScreenNavigationItem.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) {
                val detailId = it.arguments?.getString("id") ?: PlanetDetailId.IMPORTANT_ASTROLOGICAL_DATES.value
                PlanetDetailScreen(detailId)
            }
            composable(NavigationItem.CommentScreenNavigationItem.route) {
                CommentScreen(navController)
            }
            composable(
                NavigationItem.CommentDetailScreenNavigationItem.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) {
                val detailId = it.arguments?.getString("id") ?: CommentDetailId.FIRE_ELEMENT.value
                CommentDetailScreen(detailId)
            }
            composable(NavigationItem.ProfileScreenNavigationItem.route) {
                ProfileScreen()
            }
        }
    }

}