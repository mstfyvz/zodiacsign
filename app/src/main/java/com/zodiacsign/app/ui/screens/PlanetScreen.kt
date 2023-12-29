package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.data.model.PlanetCard
import com.zodiacsign.app.data.model.PlanetDetailId
import com.zodiacsign.app.ui.components.CardComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetScreen(navController: NavController) {

    val planetDetailScreenRoute = "planet_detail_screen"

    val planetCardList = listOf(
        PlanetCard(stringResource(R.string.planet_important_astrological_dates), "$planetDetailScreenRoute/${PlanetDetailId.IMPORTANT_ASTROLOGICAL_DATES.value}"),
        PlanetCard(stringResource(R.string.planet_zodiac_sign_compatibility), "$planetDetailScreenRoute/${PlanetDetailId.ZODIAC_SIGN_COMPATIBILITY.value}"),
    )

    Column(Modifier.padding(16.dp)) {
        planetCardList.forEach {
            CardComponent(it.text) {
                navController.navigate(it.route)
            }
        }
    }
}