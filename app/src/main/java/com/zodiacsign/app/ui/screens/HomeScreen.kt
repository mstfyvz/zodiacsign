package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.ui.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Column(Modifier.padding(16.dp)) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(NavigationItem.ZodiacScreenNavigationItem.route) }
        ) {
            Text(
                stringResource(R.string.home_zodiac),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 32.dp)
            )
        }
        Spacer(Modifier.padding(top = 16.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(NavigationItem.WeeklyZodiacScreenNavigationItem.route) }
        ) {
            Text(
                stringResource(R.string.home_weekly_zodiac),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 32.dp)
            )
        }
    }
}