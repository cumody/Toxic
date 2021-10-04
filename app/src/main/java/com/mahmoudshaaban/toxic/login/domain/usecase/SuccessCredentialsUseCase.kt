package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

class SuccessCredentialsUseCase : CredentialsUseCase {
    override suspend fun invoke(email: Email, password: Password): LoginResult {
        return LoginResult.Success
    }

}