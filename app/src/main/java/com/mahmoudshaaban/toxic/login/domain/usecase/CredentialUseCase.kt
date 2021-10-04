package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

/**
 * this use case consumes any information required to log in the user , and attempts to do so.
 */

interface CredentialUseCase {

    suspend operator fun invoke(
        credentials: Credentials
    ): LoginResult
}
