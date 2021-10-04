package com.mahmoudshaaban.toxic.fakes

import com.mahmoudshaaban.toxic.core.data.Result
import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.LoginResponse
import com.mahmoudshaaban.toxic.login.domain.repository.LoginRepository
import io.mockk.coEvery
import io.mockk.mockk

class FakeLoginRepository {
    val mock : LoginRepository = mockk()


    fun mockLoginWithCredentials(
        credentials: Credentials,
        result: Result<LoginResponse>
    ){
        coEvery {
            mock.loginWithCredentials(credentials)
        } returns result
    }
}