package com.zodiacsign.app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonProvider {
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    fun get(): Gson = gson
}