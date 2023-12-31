package com.zodiacsign.app.model

import android.graphics.Bitmap

data class PlanetCard(
    val text: String,
    val route: String,
    val detailId: Int,
    val image: Bitmap?
)