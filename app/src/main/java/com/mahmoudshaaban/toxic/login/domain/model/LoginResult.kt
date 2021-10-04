package com.mahmoudshaaban.toxic.login.domain.model

/**
 * A Collection of possible results for an attempt to login the user
 */

sealed class LoginResult {

    /**
     * to attempt login was successful
     */

    object Success : LoginResult()

    /**
     * this will be unsuccessful states when attempting to login
     */

    sealed class Failure : LoginResult() {
        /**
         * this will be returned if there was no account matching the requested credentials
         */
        object InvalidCredentials : Failure()

        object Unknown : Failure()
    }
}
