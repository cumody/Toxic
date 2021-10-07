package com.mahmoudshaaban.toxic.login.ui

import com.google.common.truth.Truth.assertThat
import com.mahmoudshaaban.toxic.fakes.FakeCredentialsUseCase
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

class LoginViewModelRobot {
    private val fakeCredentialsUseCase = FakeCredentialsUseCase()
    private lateinit var viewModel: LoginViewModel

    fun buildViewModel() = apply {
        viewModel = LoginViewModel(
            credentialUseCase = fakeCredentialsUseCase.mock,
        )
    }

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResult
    ) = apply {
        fakeCredentialsUseCase.mockLoginResultForCredentials(credentials, result)

    }

    fun enterEmail(email: String) = apply {
        viewModel.emailChanged(email)

    }

    fun enterPassword(password: String) = apply {
        viewModel.passwordChanged(password = password)
    }

    fun clickLoginButton() = apply { viewModel.loginButtonClicked() }
    fun clickSignUpButton() = apply { viewModel.signUpButtonCLicked() }


    fun assertViewState(expectedViewState: LoginViewState) = apply {
        assertThat(viewModel.viewState.value).isEqualTo(expectedViewState)
    }

}