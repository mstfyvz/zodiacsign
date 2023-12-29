package com.zodiacsign.app.ui.navigation

sealed class NavigationItem(val route: String) {
    object LoginScreenNavigationItem : NavigationItem("login_screen")
    object HomeScreenNavigationItem : NavigationItem("home_screen")
    object ZodiacScreenNavigationItem : NavigationItem("zodiac_screen")
    object WeeklyZodiacScreenNavigationItem : NavigationItem("weekly_zodiac_screen")
    object PlanetScreenNavigationItem : NavigationItem("planet_screen")
    object PlanetDetailScreenNavigationItem : NavigationItem("planet_detail_screen/{id}")
    object CommentScreenNavigationItem : NavigationItem("comment_screen")
    object CommentDetailScreenNavigationItem : NavigationItem("comment_detail_screen/{id}")
    object ProfileScreenNavigationItem : NavigationItem("profile_screen")
}