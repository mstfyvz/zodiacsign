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
import com.zodiacsign.app.data.model.WeeklyZodiac

@Composable
fun WeeklyZodiacScreen() {

    val listWeeklyZodiac = listOf(
        WeeklyZodiac(stringResource(R.string.aries_title), stringResource(R.string.aries_weekly_content)),
        WeeklyZodiac(stringResource(R.string.taurus_title), stringResource(R.string.taurus_weekly_content)),
        WeeklyZodiac(stringResource(R.string.gemini_title), stringResource(R.string.gemini_weekly_content)),
        WeeklyZodiac(stringResource(R.string.cancer_title), stringResource(R.string.cancer_weekly_content)),
        WeeklyZodiac(stringResource(R.string.leo_title), stringResource(R.string.leo_weekly_content)),
        WeeklyZodiac(stringResource(R.string.virgo_title), stringResource(R.string.virgo_weekly_content)),
        WeeklyZodiac(stringResource(R.string.libra_title), stringResource(R.string.libra_weekly_content)),
        WeeklyZodiac(stringResource(R.string.scorpio_title), stringResource(R.string.scorpio_weekly_content)),
        WeeklyZodiac(stringResource(R.string.sagittarius_title), stringResource(R.string.sagittarius_weekly_content)),
        WeeklyZodiac(stringResource(R.string.capricorn_title), stringResource(R.string.capricorn_weekly_content)),
        WeeklyZodiac(stringResource(R.string.aquarius_title), stringResource(R.string.aquarius_weekly_content)),
        WeeklyZodiac(stringResource(R.string.pisces_title), stringResource(R.string.pisces_weekly_content)),
    )

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        listWeeklyZodiac.forEach {
            Text(it.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(it.content, Modifier.padding(top = 16.dp, bottom = 16.dp))
        }
    }
}