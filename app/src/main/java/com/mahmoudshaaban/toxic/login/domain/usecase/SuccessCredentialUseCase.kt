package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

class SuccessCredentialUseCase : CredentialUseCase {
    override suspend fun invoke(email: Email, password: Password): LoginResult {
        return LoginResult.Success

    }
}
