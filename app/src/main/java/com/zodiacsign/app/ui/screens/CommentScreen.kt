package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.model.CommentCard
import com.zodiacsign.app.model.CommentDetailId
import com.zodiacsign.app.ui.components.CardComponent

@Composable
fun CommentScreen(navController: NavController) {

    val context = LocalContext.current

    val commentDetailScreenRoute = "comment_detail_screen"

    val commentCardList = listOf(
        CommentCard(stringResource(R.string.comment_fire_element), "$commentDetailScreenRoute/${CommentDetailId.FIRE_ELEMENT.value}", R.string.comment_fire_element_content, ContextCompat.getDrawable(context, R.drawable.ates_elementi)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_water_element), "$commentDetailScreenRoute/${CommentDetailId.WATER_ELEMENT.value}", R.string.comment_water_element_content, ContextCompat.getDrawable(context, R.drawable.su_elementi)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_air_element), "$commentDetailScreenRoute/${CommentDetailId.AIR_ELEMENT.value}", R.string.comment_air_element_content, ContextCompat.getDrawable(context, R.drawable.hava)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_earth_element), "$commentDetailScreenRoute/${CommentDetailId.EARTH_ELEMENT.value}", R.string.comment_earth_element_content, ContextCompat.getDrawable(context, R.drawable.toprak)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_full_moon), "$commentDetailScreenRoute/${CommentDetailId.FULL_MOON.value}", R.string.comment_full_moon_content, ContextCompat.getDrawable(context, R.drawable.dolunay)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_new_moon), "$commentDetailScreenRoute/${CommentDetailId.NEW_MOON.value}", R.string.comment_new_moon_content, ContextCompat.getDrawable(context, R.drawable.yeniay)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_feminine_energy), "$commentDetailScreenRoute/${CommentDetailId.FEMININE_ENERGY.value}", R.string.comment_feminine_energy_content, ContextCompat.getDrawable(context, R.drawable.disil_enerji)?.toBitmap()),
        CommentCard(stringResource(R.string.comment_masculine_energy), "$commentDetailScreenRoute/${CommentDetailId.MASCULINE_ENERGY.value}", R.string.comment_masculine_energy_content, ContextCompat.getDrawable(context, R.drawable.eril_enerji)?.toBitmap()),
    )

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        commentCardList.forEach {
            CardComponent(it.text, it.image, stringResource(it.detailId)) {
                navController.navigate(it.route)
            }
        }
    }

}