package com.mahmoudshaaban.toxic.login.domain.repository

import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResponse

/**
 * the data layer for any requests related to logging in the user
 */
interface LoginRepository {

    /**
     * given some user [credentials], try to login the user.
     *
     * @return A [Result] that contains the [LoginResponse] if successful, or error otherwise.
     */

    suspend fun loginWithCredentials(
        credentials: Credentials
    ): Result<LoginResponse>
}
