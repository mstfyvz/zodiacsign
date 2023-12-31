package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zodiacsign.app.R
import com.zodiacsign.app.model.PlanetDetailId
import com.zodiacsign.app.ui.components.StyledText
import com.zodiacsign.app.ui.components.textResource

@Composable
fun PlanetDetailScreen(detailId: String) {

    val stringId = when(detailId) {
        PlanetDetailId.IMPORTANT_ASTROLOGICAL_DATES.value -> R.string.planet_important_astrological_dates_content
        PlanetDetailId.ZODIAC_SIGN_COMPATIBILITY.value -> R.string.planet_zodiac_sign_compatibility_content
        else -> R.string.planet_important_astrological_dates_content
    }

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {

        StyledText(textResource(stringId))

    }
}