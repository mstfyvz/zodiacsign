package com.zodiacsign.app.ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

@Composable
@ReadOnlyComposable
fun textResource(@StringRes id: Int): CharSequence = LocalContext.current.resources.getText(id)