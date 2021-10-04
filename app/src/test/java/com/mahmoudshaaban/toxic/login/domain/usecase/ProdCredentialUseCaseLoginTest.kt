package com.mahmoudshaaban.toxic.login.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.fakes.FakeTokenRepository
import com.mahmoudshaaban.toxic.fakes.FakeLoginRepository
import com.mahmoudshaaban.toxic.login.domain.model.AuthToken
import com.mahmoudshaaban.toxic.fakes.FakeLoginRepository
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.Email
import com.mahmoudshaaban.toxic.login.domain.model.InvalidCredentialsException
import com.mahmoudshaaban.toxic.login.domain.model.LoginResponse
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult
import com.mahmoudshaaban.toxic.login.domain.model.Password
import com.mahmoudshaaban.toxic.login.domain.model.RefreshToken
import com.mahmoudshaaban.toxic.login.domain.model.Token
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class ProdCredentialUseCaseLoginTest {

    val defaultCredentials = Credentials(
        email = Email("testy@gmail.com"),
        password = Password("hunter2")
    )

    private val defaultToken = Token(
        AuthToken("Auth"),
        RefreshToken("Refresh")
    )

    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var tokenRepository: FakeTokenRepository

    @Before
    fun setUp(){
        loginRepository = FakeLoginRepository()
        tokenRepository = FakeTokenRepository()
    }



    @Test
    fun testSuccessfulLogin() = runBlockingTest {

        val loginResponse = Result.Success(
            LoginResponse(
                token = defaultToken
            )
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse
        )

        val useCase = ProdCredentialUseCaseLogin(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock
        )

        val userCaseResult = useCase(defaultCredentials)
        assertThat(userCaseResult).isEqualTo(LoginResult.Success)
        tokenRepository.verifyTokenStored(defaultToken)
    }

    @Test
    fun testUnknownFailure() = runBlockingTest {

        val loginResponse: Result<LoginResponse> = Result.Error(
            Throwable("Mahmoud fucked up")
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse
        )

        val useCase = ProdCredentialUseCaseLogin(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock
        )
        val useCaseResult = useCase(defaultCredentials)
        assertThat(useCaseResult).isEqualTo(LoginResult.Failure.Unknown)
        tokenRepository.verifyNoTokenStored()

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

        val loginResponse: Result<LoginResponse> = Result.Error(
            InvalidCredentialsException()
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse
        )

        val useCase = ProdCredentialUseCaseLogin(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock
        )

        val useCaseResult = useCase(defaultCredentials)
        assertThat(useCaseResult).isEqualTo(LoginResult.Failure.InvalidCredentials)
        tokenRepository.verifyNoTokenStored()

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
