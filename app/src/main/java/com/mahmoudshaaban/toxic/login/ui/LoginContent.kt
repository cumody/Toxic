package com.mahmoudshaaban.toxic.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.mahmoudshaaban.toxic.R
import com.mahmoudshaaban.toxic.core.ui.components.PrimaryButton
import com.mahmoudshaaban.toxic.core.ui.components.SecondaryButton
import com.mahmoudshaaban.toxic.core.ui.components.ToxicTextField
import com.mahmoudshaaban.toxic.core.ui.core.VerticalSpacer
import com.mahmoudshaaban.toxic.core.ui.theme.ToxicTheme
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.Email
import com.mahmoudshaaban.toxic.login.domain.model.Password

private const val APP_LOGO_WIDTH_PERCENTAGE = 0.75F

/**
 * This[LoginContent] handles all configuration that happens for this screen
 * @param[viewState] the current state of the screen to render
 * @param[onEmailChanged] A callback invoked when the user enters their username.
 * @param[onPasswordChanged] A callback invoked when the user enter their password.
 * @param[onLoginClicked] A callback invoked when the user clicks the logins button.
 * @paramp[onSignUpClicked] A callback invoked when the user clicks the sign up button
 *
 */

@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {

    Surface() {
        Box(modifier = Modifier.fillMaxSize()) {
            LogoInpusColumn(
                viewState,
                onEmailChanged,
                onPasswordChanged,
                onLoginClicked,
                onSignUpClicked
            )

            CircularProgressIndicator(
                modifier = Modifier.wrapContentSize()
                    .align(Alignment.Center),

            )
        }
    }
}

@Composable
private fun LogoInpusColumn(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.screen_padding)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.weight(1F))

        AppLogo()

        Spacer(modifier = Modifier.weight(1F))

        EmailInput(
            text = viewState.credentials.email.value,
            onTextChanged = onEmailChanged,
            errorMessage = (viewState as? LoginViewState.InputError)?.emailInputErrorMessage
        )

        VerticalSpacer(height = 12.dp)

        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LoginViewState.InputError)?.passwordInputErrorMessage
        )
        if (viewState is LoginViewState.SubmissionError) {
            Text(
                text =
                viewState.errorMessage,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(
                    top = 12.dp
                )
            )
        }

        VerticalSpacer(height = 48.dp)

        LoginButton(
            onClick = onLoginClicked,
            enabled = viewState.buttonEnabled
        )

        VerticalSpacer(height = 12.dp)

        SignupButton(
            onClick = onSignUpClicked,
            enabled = viewState.buttonEnabled
        )
    }
}

@Composable
private fun SignupButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    SecondaryButton(
        text = stringResource(R.string.sign_up),
        onclick = onClick,
        enabled = enabled
    )
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    PrimaryButton(
        text = stringResource(R.string.log_in),
        onclick = onClick,
        enabled = enabled
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?
) {
    ToxicTextField(
        text = text,
        onTextChanged = onTextChanged, textLabel = stringResource(R.string.password),
        errorMessage = errorMessage,
        visualTransfomation = PasswordVisualTransformation(),
    )
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?
) {
    ToxicTextField(
        text = text,
        onTextChanged = onTextChanged,
        textLabel = stringResource(R.string.email),
        errorMessage = errorMessage
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

    val viewState = LoginViewState.Initial

    ToxicTheme {
        LoginContent(
            viewState = viewState,
            onEmailChanged = {},
            onPasswordChanged = {},
            onLoginClicked = {},
            onSignUpClicked = {}
        )
    }
}

class LoginViewStateProvider : PreviewParameterProvider<LoginViewState> {
    override val values: Sequence<LoginViewState>
        get() {
            val activeCredentials = Credentials(
                Email("testy@mstestcase.com"),
                Password("Hunter2")

            )

            return sequenceOf(
                LoginViewState.Initial,
                LoginViewState.Active(activeCredentials),
                LoginViewState.Submitting(activeCredentials),
                LoginViewState.SubmissionError(activeCredentials, "Something went wrong"),
                LoginViewState.InputError(
                    activeCredentials,
                    "Please enter an email",
                    "Please Enter your password "
                )

            )
        }
}
