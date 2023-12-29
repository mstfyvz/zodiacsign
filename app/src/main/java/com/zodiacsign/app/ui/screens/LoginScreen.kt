package com.zodiacsign.app.ui.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.zodiacsign.app.data.model.BirthTime
import com.zodiacsign.app.data.model.PersonData
import com.zodiacsign.app.ui.MainActivity
import com.zodiacsign.app.util.Constants.PERSON_DATA
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var nameLastName by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var birthPlace by rememberSaveable { mutableStateOf("") }
    var birthTime by rememberSaveable { mutableStateOf(BirthTime()) }
    var birthTimeValue by rememberSaveable { mutableStateOf(context.getString(R.string.birth_time_label)) }
    var zodiacSign by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                stringResource(R.string.app_name),
                Modifier
                    .padding(bottom = 32.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center
            )
            OutlinedTextField(
                value = nameLastName,
                onValueChange = { nameLastName = it },
                label = { Text(stringResource(R.string.name_label)) }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            OutlinedTextField(
                value = birthPlace,
                onValueChange = { birthPlace = it },
                label = { Text(stringResource(R.string.birth_place_label)) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextButton(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.MinWidth,
                        minHeight = TextFieldDefaults.MinHeight
                    )
                    .width(TextFieldDefaults.MinWidth),
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(4.dp),
                onClick = {
                    val currentDateTime = Calendar.getInstance()
                    val startYear = currentDateTime.get(Calendar.YEAR)
                    val startMonth = currentDateTime.get(Calendar.MONTH)
                    val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
                    val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
                    val startMinute = currentDateTime.get(Calendar.MINUTE)

                    DatePickerDialog(context, { _, year, month, day ->
                        TimePickerDialog(context, { _, hour, minute ->
                            val pickedDateTime = Calendar.getInstance()
                            pickedDateTime.set(year, month, day, hour, minute)
                            birthTime = BirthTime("$year", "$month", "$day", "$hour", "$minute")
                            birthTimeValue = String.format(
                                context.getString(R.string.birth_time_value),
                                birthTime.year,
                                birthTime.month,
                                birthTime.day,
                                birthTime.hour,
                                birthTime.minute
                            )

                        }, startHour, startMinute, false).show()
                    }, startYear, startMonth, startDay).show()
                }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val birthTimeText: String =
                        if (birthTimeValue == stringResource(R.string.birth_time_value))
                            stringResource(id = R.string.birth_time_label)
                        else
                            birthTimeValue
                    Text(birthTimeText, textAlign = TextAlign.Start, modifier = Modifier.weight(4f))
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                TextField(
                    value = gender,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    placeholder = { Text(text = stringResource(R.string.gender_label)) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.male)) },
                        onClick = {
                            gender = context.getString(R.string.male)
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = stringResource(R.string.female)) },
                        onClick = {
                            gender = context.getString(R.string.female)
                            expanded = false
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Button(
                {
                    if (nameLastName.isEmpty() || birthPlace.isEmpty() || birthTimeValue == context.getString(R.string.birth_time_value) || gender.isEmpty()) {
                        Toast.makeText(context, context.getString(R.string.login_alert), Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    zodiacSign = horoscopeCalculation(birthTime.month, birthTime.day)
                    val personData = PersonData(nameLastName, birthPlace, birthTime, gender, zodiacSign)
                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtra(PERSON_DATA, personData)
                    context.startActivity(intent)
                },
                Modifier.defaultMinSize(minWidth = TextFieldDefaults.MinWidth)
            ) {
                Text(stringResource(R.string.login_text))
            }
        }
    }
}

fun horoscopeCalculation(month: String, day: String): String {
    return when (month) {
        "3" -> if (day.toInt() > 20) "Koç" else "Balık"
        "4" -> if (day.toInt() > 21) "Boğa" else "Koç"
        "5" -> if (day.toInt() > 20) "İkizler" else "Boğa"
        "6" -> if (day.toInt() > 20) "Yengeç" else "İkizler"
        "7" -> if (day.toInt() > 20) "Aslan" else "Yengeç"
        "8" -> if (day.toInt() > 20) "Başak" else "Aslan"
        "9" -> if (day.toInt() > 20) "Terazi" else "Başak"
        "10" -> if (day.toInt() > 20) "Akrep" else "Terazi"
        "11" -> if (day.toInt() > 20) "Yay" else "Akrep"
        "12" -> if (day.toInt() > 20) "Oğlak" else "Yay"
        "1" -> if (day.toInt() > 20) "Kova" else "Oğlak"
        "2" -> if (day.toInt() > 20) "Balık" else "Kova"
        else -> ""
    }
}