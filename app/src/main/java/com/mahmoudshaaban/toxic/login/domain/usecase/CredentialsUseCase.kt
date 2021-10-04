package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.login.domain.model.LoginResult

@JvmInline
@Suppress("UnusedPrivateMember")
value class Email(private val email: String)

@JvmInline
@Suppress("UnusedPrivateMember")
value class Password(private val password: String)

/**
 * this use case consumes any information required to log in the user , and attempts to do so.
 */

interface CredentialsUseCase {

    suspend operator fun invoke(
        email: Email,
        password: Password
    ): LoginResult
}
