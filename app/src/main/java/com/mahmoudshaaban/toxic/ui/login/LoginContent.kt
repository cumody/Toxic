package com.mahmoudshaaban.toxic.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.ui.components.PrimaryButton
import com.mahmoudshaaban.toxic.ui.components.SecondaryButton
import com.mahmoudshaaban.toxic.ui.components.ToxicTextField
import com.mahmoudshaaban.toxic.ui.core.VerticalSpacer
import com.mahmoudshaaban.toxic.ui.theme.ToxicTheme

private const val APP_LOGO_WIDTH_PERCENTAGE = 0.75F

/**
 * This[LoginContent] handles all configuration that happens for this screen
 * @param[viewState] the current state of the screen to render
 *
 */

@Composable
fun LoginContent(viewState: LoginViewState) {

    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.screen_padding)),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.weight(1F))

            AppLogo()

            Spacer(modifier = Modifier.weight(1F))

            UsernameInput(
                text = viewState.userName,
                onTextChanged = {}
            )

            VerticalSpacer(height = 12.dp)

            PasswordInput(
                text = viewState.password,
                onTextChanged = {}
            )

            VerticalSpacer(height = 48.dp)

            LoginButton()

            VerticalSpacer(height = 12.dp)

            SignupButton()
        }
    }
}

@Composable
private fun SignupButton() {
    SecondaryButton(
        text = stringResource(R.string.sign_up),
        onclick = {},
    )
}

@Composable
private fun LoginButton() {
    PrimaryButton(
        text = stringResource(R.string.log_in),
        onclick = {},
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit
) {
    ToxicTextField(
        text = text,
        onTextChanged = onTextChanged, textLabel = stringResource(R.string.password)
    )
}

@Composable
private fun UsernameInput(
    text: String,
    onTextChanged: (String) -> Unit
) {
    ToxicTextField(
        text = text,
        onTextChanged = onTextChanged, textLabel = stringResource(R.string.username)
    )
}

@Composable
private fun AppLogo() {
    Image(
        painter = painterResource(id = R.drawable.ic_toxic_chekmark),
        contentDescription = stringResource(R.string.app_logo_content_description),
        modifier = Modifier.fillMaxWidth(APP_LOGO_WIDTH_PERCENTAGE)
    )
}

@Preview(
    name = "Night Mode - Empty",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode - Empty",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
@Suppress("UnusedPrivateMember")
private fun EmptyLoginScreenPreview() {

    val viewState = LoginViewState(
        userName = "",
        password = ""
    )

    ToxicTheme {
        LoginContent(viewState)
    }
}
