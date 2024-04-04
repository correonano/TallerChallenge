package com.nano.tallerchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nano.tallerchallenge.LoginViewModel

@Composable
fun App() {

    var username by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    val loginViewModel = viewModel<LoginViewModel>()

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        username = username,
        password = password,
        { username = it },
        { password = it },
        { loginViewModel.login(username, password) },
        uiState
    )
}
