package com.senaisp.carteirinhadigital.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.senaisp.carteirinhadigital.feature.login.data.repository.LoginRepository


class LoginViewModelFactory(private val repository: LoginRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(LoginViewModel::class.java))
        @Suppress("UNCHECKED_CAST")
        return LoginViewModel(repository) as T
    }
}
