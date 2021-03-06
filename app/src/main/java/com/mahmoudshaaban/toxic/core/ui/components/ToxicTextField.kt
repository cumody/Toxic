package com.mahmoudshaaban.toxic.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.core.ui.theme.TextFieldShape
import com.mahmoudshaaban.toxic.core.ui.theme.ToxicTheme

/**
 * This is a custom implementation of an [OutlinedTextField] to ensure that it has the TOA branding
 * and styling that we expect.
 *
 * @param[text] The current text inside the input.
 * @param[onTextChanged] A callback invoked whenever the user modifies the text inside this input.
 * @param[labelText] The label that shows above the input when focused.
 * @param[modifier] An optional [Modifier] to configure this component.
 */

@Composable
fun ToxicTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textLabel: String,
    errorMessage: String? = null,
    visualTransfomation: VisualTransformation = VisualTransformation.None
) {
    Column {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChanged,
            label = { Text(text = textLabel) },
            shape = TextFieldShape,
            modifier = modifier
                .heightIn(dimensionResource(id = R.dimen.text_field_height))
                .fillMaxWidth(),
            isError = (errorMessage != null),
            visualTransformation = visualTransfomation
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(top = 4.dp, start = 16.dp)
            )
        }
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
private fun ToxicTextFieldPreview() {
    androidx.compose.material.Surface() {
        ToxicTheme {
            ToxicTextField(
                text = "TOA Text Field", onTextChanged = {},
                textLabel = "Label"
            )
        }
    }
}
