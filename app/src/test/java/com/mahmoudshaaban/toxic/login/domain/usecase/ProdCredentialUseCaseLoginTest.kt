package com.mahmoudshaaban.toxic.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.fakes.FakeLoginRepository
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.Email
import com.mahmoudshaaban.toxic.login.domain.model.InvalidCredentialsException
import com.mahmoudshaaban.toxic.login.domain.model.LoginResponse
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult
import com.mahmoudshaaban.toxic.login.domain.model.Password
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class ProdCredentialUseCaseLoginTest {
    @Test
    fun testSuccessfulLogin() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("testy@gmail.com"),
            password = Password("hunter2")
        )

        val mockLoginResponse = Result.Success(
            LoginResponse(authToken = "Success")
        )
        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockLoginResponse
            )
        }

        val useCase = ProdCredentialUseCaseLogin(loginRepository.mock)
        val userCaseResult = useCase(inputCredentials)
        assertThat(userCaseResult).isEqualTo(LoginResult.Success)
    }

    @Test
    fun testUnknowFailure() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("testy@gmail.com"),
            password = Password("hunter2")
        )

        val mockLoginResponse: Result<LoginResponse> = Result.Error(
            Throwable("Mahmoud fucked up")
        )

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockLoginResponse
            )
        }

        val useCase = ProdCredentialUseCaseLogin(loginRepository.mock)
        val useCaseResult = useCase(inputCredentials)
        assertThat(useCaseResult).isEqualTo(LoginResult.Failure.Unknown)
    }

    @Test
    fun testInvalidCredentials() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("testy@gmail.com"),
            password = Password("hunter2")
        )

        val mockLoginResponse: Result<LoginResponse> = Result.Error(
            InvalidCredentialsException()
        )

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockLoginResponse
            )
        }

        val useCase = ProdCredentialUseCaseLogin(loginRepository.mock)
        val useCaseResult = useCase(inputCredentials)
        assertThat(useCaseResult).isEqualTo(LoginResult.Failure.InvalidCredentials)
    }
}
