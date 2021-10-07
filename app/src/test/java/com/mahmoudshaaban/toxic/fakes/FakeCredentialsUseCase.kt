package com.mahmoudshaaban.toxic.fakes

import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult
import com.mahmoudshaaban.toxic.login.domain.usecase.CredentialUseCase
import io.mockk.coEvery
import io.mockk.mockk

class FakeCredentialsUseCase {

    val mock: CredentialUseCase = mockk()

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResult
    ) {

        coEvery {
            mock.invoke(credentials = credentials)
        } returns result

    }
}