package com.mahmoudshaaban.toxic.login.domain.model


/**
 * A Response from any request to login to an external service
 */
data class LoginResponse(
    private val authToken: String
)