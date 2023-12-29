package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zodiacsign.app.R
import com.zodiacsign.app.data.model.CommentCard
import com.zodiacsign.app.data.model.CommentDetailId
import com.zodiacsign.app.ui.components.CardComponent

@Composable
fun CommentScreen(navController: NavController) {

    val commentDetailScreenRoute = "comment_detail_screen"

    val commentCardList = listOf(
        CommentCard(stringResource(R.string.comment_fire_element), "$commentDetailScreenRoute/${CommentDetailId.FIRE_ELEMENT.value}"),
        CommentCard(stringResource(R.string.comment_water_element), "$commentDetailScreenRoute/${CommentDetailId.WATER_ELEMENT.value}"),
        CommentCard(stringResource(R.string.comment_air_element), "$commentDetailScreenRoute/${CommentDetailId.AIR_ELEMENT.value}"),
        CommentCard(stringResource(R.string.comment_earth_element), "$commentDetailScreenRoute/${CommentDetailId.EARTH_ELEMENT.value}"),
        CommentCard(stringResource(R.string.comment_full_moon), "$commentDetailScreenRoute/${CommentDetailId.FULL_MOON.value}"),
        CommentCard(stringResource(R.string.comment_new_moon), "$commentDetailScreenRoute/${CommentDetailId.NEW_MOON.value}"),
        CommentCard(stringResource(R.string.comment_feminine_energy), "$commentDetailScreenRoute/${CommentDetailId.FEMININE_ENERGY.value}"),
        CommentCard(stringResource(R.string.comment_masculine_energy), "$commentDetailScreenRoute/${CommentDetailId.MASCULINE_ENERGY.value}"),
    )

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        commentCardList.forEach {
            CardComponent(it.text) {
                navController.navigate(it.route)
            }
        }
    }

}