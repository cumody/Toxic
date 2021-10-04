package com.mahmoudshaaban.toxic.login.domain.usecase

import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.login.domain.model.LoginResult



@JvmInline
value class Email(private val email : String)

@JvmInline
value class Password(private val password : String)


/**
 * this use case consumes any information required to log in the user , and attempts to do so.
 */

interface LoginUseCase {
    
    suspend operator fun invoke(
        email: Email,
        password: Password
    ) : LoginResult

}