package com.zodiacsign.app.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(text: String, image: Bitmap? = null, content: String, onClick: () -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        onClick = onClick
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            image?.let {
                Image(bitmap = it.asImageBitmap(), contentDescription = "", modifier = Modifier
                    .size(100.dp)
                    .width(100.dp)
                    .height(100.dp)
                    .clip(CircleShape))
            }
            Column(
                Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()) {
                Text(text, fontSize = 24.sp)
                Text(content, overflow = TextOverflow.Ellipsis, maxLines = 3)
            }
        }
    }
    Spacer(Modifier.padding(top = 16.dp))
}