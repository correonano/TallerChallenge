package com.nano.tallerchallenge.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nano.tallerchallenge.data.UIState


@Composable
fun LoginScreen(
    username: String,
    password: String,
    userChanged: (String) -> Unit,
    passwordChanged: (String) -> Unit,
    onClick: () -> Unit,
    uiState: UIState
) {

    val isLoading = uiState is UIState.Loading
    val isError = uiState is UIState.Error

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (isLoading)
            CircularProgressIndicator(modifier = Modifier.size(36.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text(text = "Login", fontSize = 36.sp)

            OutlinedTextField(
                value = username,
                onValueChange = userChanged,
                label = {
                    Text(text = "Username")
                },
                isError = isError
            )

            OutlinedTextField(
                value = password,
                onValueChange = passwordChanged,
                label = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                isError = isError,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "works with: user pass", fontSize = 8.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onClick, enabled = !isLoading) {
                Text(text = "LOGIN")
            }

            if (uiState is UIState.Success) {
                Toast.makeText(LocalContext.current, "Login OK!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
