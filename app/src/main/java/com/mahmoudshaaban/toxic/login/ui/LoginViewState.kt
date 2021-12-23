package com.mahmoudshaaban.toxic.login.ui

import com.mahmoudshaaban.toxic.login.domain.model.Credentials

/**
 * A sealed defining all possible states of our login screen.
 *
 * @param[credentials] the current credentials entered by the user
 * @param[buttonEnabled] if true , the buttons on the login screen can accept clicks
 * false otherwise
 */

sealed class LoginViewState(
    open val credentials: Credentials,
    open val buttonEnabled: Boolean = true
) {

    /**
     * the initial state of the screen with nothing input.
     */
    object Initial : LoginViewState(
        credentials = Credentials(),
    )

    /**
     * the state of the screen as the user is entering email information
     */

    data class Active(
        override val credentials: Credentials,
    ) : LoginViewState(
        credentials,
    )

    /**
     * The state of the screen as the user is attempting to login
     */

    data class Submitting(
        override val credentials: Credentials,
    ) : LoginViewState(
        credentials = credentials,
        buttonEnabled = false
    )

    /**
     * the state of the screen when there is an error logging in.
     */

    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: String
    ) : LoginViewState(
        credentials = credentials
    )

    /**
     * the state of the screen when the user tries to sumbit with invalid inputs
     *
     */

    data class InputError(
        override val credentials: Credentials,
        val emailInputErrorMessage: String?,
        val passwordInputErrorMessage: String?
    ) : LoginViewState(
        credentials = credentials
    )
}
