package com.zodiacsign.app.ui.navigation

sealed class NavigationItem (val route: String) {
    object LoginScreenNavigationItem : NavigationItem("login_screen")
    object HomeScreenNavigationItem : NavigationItem("home_screen")
    object PlanetScreenNavigationItem : NavigationItem("planet_screen")
    object CommentScreenNavigationItem : NavigationItem("comment_screen")
    object ProfileScreenNavigationItem : NavigationItem("profile_screen")
}