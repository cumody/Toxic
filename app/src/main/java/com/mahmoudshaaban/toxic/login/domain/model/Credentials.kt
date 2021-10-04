package com.mahmoudshaaban.toxic.login.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
value class Password(val value: String)
@Suppress("UnusedPrivateMember")
value class Email(private val email: String)

@JvmInline
@Suppress("UnusedPrivateMember")
value class Password(private val password: String)


data class Credentials(
    val email: Email,
    val password: Password

)
