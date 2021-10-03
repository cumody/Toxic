package com.mahmoudshaaban.toxic.ui.login

/**
 * [LoginViewState] this defines the state of login screen
 * @param[name] the current text entered in the username field.
 * @param[password] the current password in the password field
 *
 */
data class LoginViewState(
    val userName: String,
    val password: String
)
