package com.zodiacsign.app.ui.screens

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zodiacsign.app.R
import com.zodiacsign.app.data.model.PersonData
import com.zodiacsign.app.util.Constants.PERSON_DATA

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    var personData by rememberSaveable { mutableStateOf(PersonData()) }

    val context = LocalContext.current
    val activity = context as Activity

    activity.intent.extras?.let {
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            it.getParcelable(PERSON_DATA, PersonData::class.java)
        } else {
            @Suppress("DEPRECATION") it.getParcelable(PERSON_DATA) as? PersonData
        }
        data?.let { personDataIntent ->
            personData = personDataIntent
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                stringResource(R.string.profile_title),
                Modifier
                    .padding(bottom = 32.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(32.dp))
            OutlinedTextField(
                value = personData.nameLastName, onValueChange = {},
                label = { Text(stringResource(R.string.name_label)) },
                readOnly = true,
            )
            Spacer(Modifier.padding(8.dp))
            OutlinedTextField(
                value = personData.gender, onValueChange = {},
                label = { Text(stringResource(R.string.gender_label)) },
                readOnly = true,
            )
            Spacer(Modifier.padding(8.dp))
            OutlinedTextField(
                value = personData.birthPlace, onValueChange = {},
                label = { Text(stringResource(R.string.birth_place_label)) },
                readOnly = true,
            )
            Spacer(Modifier.padding(8.dp))
            OutlinedTextField(
                value = String.format(
                    context.getString(R.string.birth_time_value),
                    personData.birthTime.year,
                    personData.birthTime.month,
                    personData.birthTime.day,
                    personData.birthTime.hour,
                    personData.birthTime.minute
                ),
                onValueChange = {},
                label = { Text(stringResource(R.string.birth_time_label)) },
                readOnly = true,
            )
        }
    }
}