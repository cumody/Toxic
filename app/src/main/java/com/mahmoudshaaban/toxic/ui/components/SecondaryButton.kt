package com.mahmoudshaaban.toxic.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.ui.theme.ButtonShape
import com.mahmoudshaaban.toxic.ui.theme.ToxicTheme

/**
 * This is a custom [TextButton] that provides the shape and styling expected
 * in the TOA application.
 *
 * @param[text] The text inside the button.
 * @param[onClick] A callback invoked when the user clicks the button.
 * @param[modifier] An optional [Modifier] to configure this component.
 */
@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onclick: () -> Unit = {},
) {

    TextButton(
        onClick = { onclick },
        shape = ButtonShape,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.buttonHeight))
            .fillMaxWidth()
    ) {
        Text(text = text.toUpperCase(Locale.current))
    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
@Suppress("UnusedPrivateMember")
private fun SecondaryButtonPreview() {
    ToxicTheme {
        Surface() {
            SecondaryButton(text = "Secondary Button")
        }
    }
}
