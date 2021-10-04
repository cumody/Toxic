package com.mahmoudshaaban.toxic.login.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
@Suppress("UnusedPrivateMember")
value class Password(val password: String)

data class Credentials(
    val email: Email,
    val password: Password

)
