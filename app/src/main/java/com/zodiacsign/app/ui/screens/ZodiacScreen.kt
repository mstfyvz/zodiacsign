package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zodiacsign.app.R
import com.zodiacsign.app.data.model.Zodiac

@Composable
fun ZodiacScreen() {

    val listZodiac = listOf(
        Zodiac(stringResource(R.string.aries_title), stringResource(R.string.aries_content)),
        Zodiac(stringResource(R.string.taurus_title), stringResource(R.string.taurus_content)),
        Zodiac(stringResource(R.string.gemini_title), stringResource(R.string.gemini_content)),
        Zodiac(stringResource(R.string.cancer_title), stringResource(R.string.cancer_content)),
        Zodiac(stringResource(R.string.leo_title), stringResource(R.string.leo_content)),
        Zodiac(stringResource(R.string.virgo_title), stringResource(R.string.virgo_content)),
        Zodiac(stringResource(R.string.libra_title), stringResource(R.string.libra_content)),
        Zodiac(stringResource(R.string.scorpio_title), stringResource(R.string.scorpio_content)),
        Zodiac(stringResource(R.string.sagittarius_title), stringResource(R.string.sagittarius_content)),
        Zodiac(stringResource(R.string.capricorn_title), stringResource(R.string.capricorn_content)),
        Zodiac(stringResource(R.string.aquarius_title), stringResource(R.string.aquarius_content)),
        Zodiac(stringResource(R.string.pisces_title), stringResource(R.string.pisces_content)),
    )

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        listZodiac.forEach {
            Text(it.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(it.content, Modifier.padding(top = 16.dp, bottom = 16.dp))
        }
    }
}