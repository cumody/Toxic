package com.mahmoudshaaban.toxic.login.domain.model

import com.mahmoudshaaban.toxic.login.domain.usecase.Email
import com.mahmoudshaaban.toxic.login.domain.usecase.Password

sealed class LoginType {

    data class Credentials(
        val email : Email,
        val password: Password
    )

    object Google : LoginType()


}