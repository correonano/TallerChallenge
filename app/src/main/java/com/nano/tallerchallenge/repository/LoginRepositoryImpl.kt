package com.nano.tallerchallenge.repository

import com.nano.tallerchallenge.data.UIState
import com.nano.tallerchallenge.data.User
import kotlinx.coroutines.delay

class LoginRepositoryImpl: LoginRepository {

    override suspend fun login(username: String, password: String): UIState {
        delay(3000)
        return if(username == "user" && password == "pass") {
            UIState.Success(User("Jorge"))
        } else {
            UIState.Error("error")
        }
    }
}