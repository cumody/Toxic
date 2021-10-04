package com.mahmoudshaaban.toxic.fakes

import com.mahmoudshaaban.toxic.login.domain.model.Token
import com.mahmoudshaaban.toxic.login.domain.repository.AuthTokenRepository
import io.mockk.coVerify
import io.mockk.mockk

class FakeTokenRepository {

    val mock: AuthTokenRepository = mockk(
        relaxed = true,
    )

    fun verifyTokenStored(token: Token) {
        coVerify {
            mock.storeToken(token)
        }
    }

    fun verifyNoTokenStored() {
        coVerify(exactly = 0) {
            mock.storeToken(any())
        }
    }
}
