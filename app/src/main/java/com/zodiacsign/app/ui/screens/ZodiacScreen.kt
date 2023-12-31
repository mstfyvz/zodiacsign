package com.zodiacsign.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.zodiacsign.app.R
import com.zodiacsign.app.model.Zodiac

@Composable
fun ZodiacScreen() {

    val context = LocalContext.current

    val listZodiac = listOf(
        Zodiac(stringResource(R.string.aries_title), stringResource(R.string.aries_content), ContextCompat.getDrawable(context, R.drawable.koc)?.toBitmap()),
        Zodiac(stringResource(R.string.taurus_title), stringResource(R.string.taurus_content), ContextCompat.getDrawable(context, R.drawable.boga)?.toBitmap()),
        Zodiac(stringResource(R.string.gemini_title), stringResource(R.string.gemini_content), ContextCompat.getDrawable(context, R.drawable.ikizler)?.toBitmap()),
        Zodiac(stringResource(R.string.cancer_title), stringResource(R.string.cancer_content), ContextCompat.getDrawable(context, R.drawable.yengec)?.toBitmap()),
        Zodiac(stringResource(R.string.leo_title), stringResource(R.string.leo_content), ContextCompat.getDrawable(context, R.drawable.aslan)?.toBitmap()),
        Zodiac(stringResource(R.string.virgo_title), stringResource(R.string.virgo_content), ContextCompat.getDrawable(context, R.drawable.basak)?.toBitmap()),
        Zodiac(stringResource(R.string.libra_title), stringResource(R.string.libra_content), ContextCompat.getDrawable(context, R.drawable.terazi)?.toBitmap()),
        Zodiac(stringResource(R.string.scorpio_title), stringResource(R.string.scorpio_content), ContextCompat.getDrawable(context, R.drawable.akrep)?.toBitmap()),
        Zodiac(stringResource(R.string.sagittarius_title), stringResource(R.string.sagittarius_content), ContextCompat.getDrawable(context, R.drawable.yay)?.toBitmap()),
        Zodiac(stringResource(R.string.capricorn_title), stringResource(R.string.capricorn_content), ContextCompat.getDrawable(context, R.drawable.oglak)?.toBitmap()),
        Zodiac(stringResource(R.string.aquarius_title), stringResource(R.string.aquarius_content), ContextCompat.getDrawable(context, R.drawable.kova)?.toBitmap()),
        Zodiac(stringResource(R.string.pisces_title), stringResource(R.string.pisces_content), ContextCompat.getDrawable(context, R.drawable.balik)?.toBitmap()),
    )

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
        listZodiac.forEach {
            Text(it.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            it.image?.let { image ->
                Image(bitmap = image.asImageBitmap(), contentDescription = "", modifier = Modifier.padding(top = 8.dp)
                    .size(100.dp)
                    .width(100.dp)
                    .height(100.dp)
                    .clip(CircleShape))
            }
            Text(it.content, Modifier.padding(top = 16.dp, bottom = 16.dp))
        }
    }
}