package com.zodiacsign.app.model

import android.graphics.Bitmap

data class CommentCard(
    val text: String,
    val route: String,
    val detailId: Int,
    val image: Bitmap?
)