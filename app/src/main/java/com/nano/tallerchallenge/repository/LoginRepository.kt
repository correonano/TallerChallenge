package com.nano.tallerchallenge.repository

import com.nano.tallerchallenge.data.UIState

interface LoginRepository {
    suspend fun login(username: String, password: String) : UIState
}