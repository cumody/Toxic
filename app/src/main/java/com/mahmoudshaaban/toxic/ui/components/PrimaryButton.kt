package com.mahmoudshaaban.toxic.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.ui.theme.ButtonShape

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onclick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primary,
    textColor: Color = MaterialTheme.colors.onPrimary
) {

    val buttonColors = buttonColors(
        backgroundColor = backgroundColor
    )

    Button(
        onClick = { onclick },
        colors = buttonColors,
        shape = ButtonShape,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.buttonHeight))
            .fillMaxWidth()
    ) {
        Text(text = text.toUpperCase(Locale.current), color = textColor)
    }
}



