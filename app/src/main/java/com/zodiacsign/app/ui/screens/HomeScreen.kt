package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.ui.components.CardComponent
import com.zodiacsign.app.ui.navigation.NavigationItem

@Composable
fun HomeScreen(navController: NavController) {

    Column(Modifier.padding(16.dp)) {
        CardComponent(stringResource(R.string.home_zodiac), null, stringResource(R.string.aries_content)) {
            navController.navigate(NavigationItem.ZodiacScreenNavigationItem.route)
        }
        CardComponent(stringResource(R.string.home_weekly_zodiac), null, stringResource(R.string.aries_weekly_content)) {
            navController.navigate(NavigationItem.WeeklyZodiacScreenNavigationItem.route)
        }
    }
}