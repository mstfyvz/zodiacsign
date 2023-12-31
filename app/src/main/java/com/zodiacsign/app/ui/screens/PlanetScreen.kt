package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.model.PlanetCard
import com.zodiacsign.app.model.PlanetDetailId
import com.zodiacsign.app.ui.components.CardComponent

@Composable
fun PlanetScreen(navController: NavController) {

    val context = LocalContext.current

    val planetDetailScreenRoute = "planet_detail_screen"

    val planetCardList = listOf(
        PlanetCard(stringResource(R.string.planet_important_astrological_dates), "$planetDetailScreenRoute/${PlanetDetailId.IMPORTANT_ASTROLOGICAL_DATES.value}", R.string.planet_important_astrological_dates_content, ContextCompat.getDrawable(context, R.drawable.onemli_tarihler)?.toBitmap()),
        PlanetCard(stringResource(R.string.planet_zodiac_sign_compatibility), "$planetDetailScreenRoute/${PlanetDetailId.ZODIAC_SIGN_COMPATIBILITY.value}", R.string.planet_zodiac_sign_compatibility_content, ContextCompat.getDrawable(context, R.drawable.burcuyumu)?.toBitmap()),
    )

    Column(Modifier.padding(16.dp)) {
        planetCardList.forEach {
            CardComponent(it.text, it.image, stringResource(it.detailId)) {
                navController.navigate(it.route)
            }
        }
    }
}