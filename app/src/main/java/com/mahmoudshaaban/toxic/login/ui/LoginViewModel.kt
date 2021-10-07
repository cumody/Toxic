package com.mahmoudshaaban.toxic.login.ui

import androidx.lifecycle.ViewModel
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.Email
import com.mahmoudshaaban.toxic.login.domain.model.Password
import com.mahmoudshaaban.toxic.login.domain.usecase.CredentialUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel(
    private val credentialUseCase: CredentialUseCase,
) : ViewModel() {

    private val _viewState: MutableStateFlow<LoginViewState> =
        MutableStateFlow(LoginViewState.Initial)
    val viewState: StateFlow<LoginViewState> = _viewState

    fun emailChanged(email: String) {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedEmail(email = email)
        )
    }

    fun passwordChanged(password: String) {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedPassword(password = password)
        )
    }

    fun loginButtonClicked() {
        TODO()
    }

    fun signUpButtonCLicked() {
        TODO()
    }

    fun Credentials.withUpdatedEmail(email: String): Credentials {
        return this.copy(email = Email(email))
    }

    fun Credentials.withUpdatedPassword(password: String): Credentials {
        return this.copy(email = Email(password))
    }


}