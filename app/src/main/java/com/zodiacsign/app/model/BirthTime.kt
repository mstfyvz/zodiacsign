package com.zodiacsign.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BirthTime(
    val year: String = "",
    val month: String = "",
    val day: String = "",
    val hour: String = "",
    val minute: String = ""
): Parcelable
