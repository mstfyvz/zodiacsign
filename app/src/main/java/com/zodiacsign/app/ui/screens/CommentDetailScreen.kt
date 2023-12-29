package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zodiacsign.app.R
import com.zodiacsign.app.data.model.CommentDetailId
import com.zodiacsign.app.ui.components.StyledText
import com.zodiacsign.app.ui.components.textResource

@Composable
fun CommentDetailScreen(detailId: String) {

    val stringId = when(detailId) {
        CommentDetailId.FIRE_ELEMENT.value -> R.string.comment_fire_element_content
        CommentDetailId.WATER_ELEMENT.value -> R.string.comment_water_element_content
        CommentDetailId.AIR_ELEMENT.value -> R.string.comment_air_element_content
        CommentDetailId.EARTH_ELEMENT.value -> R.string.comment_earth_element_content
        CommentDetailId.FULL_MOON.value -> R.string.comment_full_moon_content
        CommentDetailId.NEW_MOON.value -> R.string.comment_new_moon_content
        CommentDetailId.FEMININE_ENERGY.value -> R.string.comment_feminine_energy_content
        CommentDetailId.MASCULINE_ENERGY.value -> R.string.comment_masculine_energy_content
        else -> R.string.comment_fire_element_content
    }

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        StyledText(textResource(stringId))
    }

}