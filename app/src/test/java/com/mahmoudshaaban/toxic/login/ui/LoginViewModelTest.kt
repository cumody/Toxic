package com.mahmoudshaaban.toxic.login.ui

import com.mahmoudshaaban.toxic.login.domain.model.Credentials
import com.mahmoudshaaban.toxic.login.domain.model.Email
import com.mahmoudshaaban.toxic.login.domain.model.Password
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {
    private lateinit var testRobot: LoginViewModelRobot

    private val defaultCredentials = Credentials(
        Email("testy@mctestface.com"),
        Password("Hunter2"),
    )

    @Before
    fun setUp() {
        testRobot = LoginViewModelRobot()
    }

    @Test
    fun testInitialState() {
        testRobot
            .buildViewModel()
            .assertViewState(LoginViewState.Initial)
    }

    @Test
    fun testUpdateCredentials() {
        val credentials = defaultCredentials

        testRobot
            .buildViewModel()
            .enterEmail(credentials.email.value)
            .enterPassword(credentials.password.value)
            .assertViewState(LoginViewState.Active(credentials))
    }
}
