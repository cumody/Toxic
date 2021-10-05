package com.mahmoudshaaban.toxic.login.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
@Suppress("UnusedPrivateMember")
value class Password(val value: String)

data class Credentials(
    val email: Email = Email(""),
    val password: Password = Password(""),
)
