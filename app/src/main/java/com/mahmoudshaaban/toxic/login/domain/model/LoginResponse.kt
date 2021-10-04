package com.mahmoudshaaban.toxic.login.domain.model

/**
 * A Response from any request to login to an external service
 */
@Suppress("UnusedPrivateMember")
data class LoginResponse(

    val token: Token

    private val authToken: String

)
