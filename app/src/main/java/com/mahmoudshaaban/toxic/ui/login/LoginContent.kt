package com.mahmoudshaaban.toxic.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoudshaaban.toxic.ui.components.PrimaryButton
import com.mahmoudshaaban.toxic.ui.components.SecondaryButton
import com.mahmoudshaaban.toxic.ui.theme.ToxicTheme


/**
 * This[LoginContent] handles all configuration that happens for this screen
 * @param[viewState] the current state of the screen to render
 *
 */
@Composable
fun LoginContent(viewState: LoginViewState) {

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Spacer(modifier = Modifier.weight(1F))

            PrimaryButton(
                text = "Login In",
                onclick = {},
                backgroundColor = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(12.dp))

            SecondaryButton(
                text = "Sign up",
                onclick = {},
                contentColor = MaterialTheme.colors.onPrimary)
            
        }
        
    }

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
        LoginContent(viewState = viewState)
    }

}