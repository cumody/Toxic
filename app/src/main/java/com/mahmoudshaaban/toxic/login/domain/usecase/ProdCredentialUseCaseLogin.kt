package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.InvalidCredentialsException
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult
import com.mahmoudshaaban.toxic.login.domain.repository.LoginRepository


/**
 * a concrete implementation of a [ProdCredentialUseCaseLogin] that will request logging in via the [loginRepository]
 */
class ProdCredentialUseCaseLogin(
    private val loginRepository: LoginRepository
) : CredentialUseCase {
    override suspend fun invoke(credentials: Credentials): LoginResult {
        val repoResult = loginRepository.loginWithCredentials(credentials)

        return when (repoResult) {
            is Result.Success -> {
                // Store the auth token here
                return LoginResult.Success
            }
            is Result.Error -> {
                loginResultForError(repoResult)
            }
        }
    }

    /**
     * checks the possible error scenarios for the [repoResult] and maps to an appropriate
     * [LoginResult]
     */

    private fun loginResultForError(repoResult: Result.Error) =
        when (repoResult.error) {
            is InvalidCredentialsException -> {
                LoginResult.Failure.InvalidCredentials
            }
            else -> {
                LoginResult.Failure.Unknown
            }
        }
}