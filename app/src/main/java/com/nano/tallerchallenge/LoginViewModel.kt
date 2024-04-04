package com.nano.tallerchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nano.tallerchallenge.data.UIState
import com.nano.tallerchallenge.repository.LoginRepository
import com.nano.tallerchallenge.repository.LoginRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository = LoginRepositoryImpl()): ViewModel() {

    private val _uiStatus: MutableStateFlow<UIState> = MutableStateFlow(UIState.Empty())
    val uiState: StateFlow<UIState> = _uiStatus.asStateFlow()

    fun login(username: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _uiStatus.update {
                UIState.Loading()
            }

            val userStatus = loginRepository.login(username.trim(), password.trim())

            _uiStatus.update {
                userStatus
            }
        }

    }
}