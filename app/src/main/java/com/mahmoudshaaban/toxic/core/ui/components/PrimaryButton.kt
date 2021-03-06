package com.mahmoudshaaban.toxic.core.ui.components

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.core.ui.theme.ButtonShape
import com.mahmoudshaaban.toxic.core.ui.theme.ToxicTheme

/**
 * This is a custom [Button] that provides the shape and styling expected
 * in the TOA application.
 *
 * @param[text] The text inside the button.
 * @param[onClick] A callback invoked when the user clicks the button.
 * @param[modifier] An optional [Modifier] to configure this component.
 * @param[backgroundColor] The color of the button in an enabled state.
 */

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onclick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primary,
    enabled: Boolean = true,
) {

    val buttonColors = buttonColors(
        backgroundColor = backgroundColor,
    )

    Button(
        onClick = { onclick },
        colors = buttonColors,
        shape = ButtonShape,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.buttonHeight))
            .fillMaxWidth(),
        enabled = enabled
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
private fun PrimaryButtonPreview() {
    ToxicTheme {
        PrimaryButton(text = "Primary Button")
    }
}

@Preview(
    name = "Night Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
@Suppress("UnusedPrivateMember")
private fun DisabledPrimaryButtonPreview() {
    ToxicTheme {
        PrimaryButton(
            text = "Primary Button",
            onclick = {},
            enabled = false
        )
    }
}
