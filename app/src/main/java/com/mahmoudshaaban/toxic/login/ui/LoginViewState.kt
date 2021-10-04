package com.mahmoudshaaban.toxic.login.ui

/**
 * [LoginViewState] this defines the state of login screen
 * @param[email] the current text entered in the email field.
 * @param[password] the current password in the password field
 *
 */
data class LoginViewState(
    val email: String,
    val password: String,
)
