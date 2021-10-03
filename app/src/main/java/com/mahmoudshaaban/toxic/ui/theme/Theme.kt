package com.mahmoudshaaban.toxic.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun ToxicTheme(content: @Composable() () -> Unit) {
    val colors = lightColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}
