package com.mahmoudshaaban.toxic.login.ui

import com.google.common.truth.Truth.assertThat
import com.mahmoudshaaban.toxic.fakes.FakeCredentialsLoginUseCase
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

class LoginViewModelRobot {
    private val fakeCredentialsLoginUseCase = FakeCredentialsLoginUseCase()

    private lateinit var viewModel: LoginViewModel

    fun buildViewModel() = apply {
        viewModel = LoginViewModel()
    }

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResult,
    ) = apply {
        fakeCredentialsLoginUseCase.mockLoginResultForCredentials(credentials, result)
    }

    fun enterEmail(email: String) = apply {
        viewModel.emailChanged(email)
    }

    fun enterPassword(password: String) = apply {
        viewModel.passwordChanged(password)
    }

    fun clickLogInButton() = apply {
        viewModel.loginButtonClicked()
    }

    fun clickSignUpButton() = apply {
        viewModel.signUpButtonClicked()
    }

    fun assertViewState(expectedViewState: LoginViewState) = apply {
        assertThat(viewModel.viewState.value).isEqualTo(expectedViewState)
    }
}
