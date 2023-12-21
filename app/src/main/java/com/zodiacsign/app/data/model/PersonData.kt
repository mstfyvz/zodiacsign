package com.zodiacsign.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonData(
    val nameLastName: String = "",
    val birthPlace: String = "",
    val birthTime: BirthTime = BirthTime("", "", "", "", ""),
    val gender: String = ""
): Parcelable
