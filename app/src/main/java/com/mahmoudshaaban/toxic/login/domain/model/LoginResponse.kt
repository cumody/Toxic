package com.mahmoudshaaban.toxic.login.domain.model

/**
 * A Response from any request to login to an external service
 */
@Suppress("UnusedPrivateMember")
/**
 * A response from any request to login to an external service.
 */
data class LoginResponse(
    val token: Token,
)
