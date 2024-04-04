package com.nano.tallerchallenge.data

sealed class UIState(user: User? = null, errorMessage: String? = null) {
    class Loading : UIState()
    class Empty : UIState()
    class Success(user: User?) : UIState(user)
    class Error(errorMessage: String?) : UIState(errorMessage = errorMessage)
}


data class User(val name: String)