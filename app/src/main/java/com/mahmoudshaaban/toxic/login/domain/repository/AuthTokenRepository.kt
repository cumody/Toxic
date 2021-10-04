package com.mahmoudshaaban.toxic.login.domain.repository

import com.mahmoudshaaban.toxic.login.domain.model.AuthToken
import com.mahmoudshaaban.toxic.login.domain.model.Token

interface AuthTokenRepository {

    suspend fun storeToken(
        token: Token
    )

    suspend fun fetchToken(): AuthToken?
}
