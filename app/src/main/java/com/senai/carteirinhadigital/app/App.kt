package com.senai.carteirinhadigital.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.senai.carteirinhadigital.core.desingsystem.theme.CarteirinhaDigitalTheme
import com.senai.carteirinhadigital.app.navegation.AppNavHost

@Composable
fun App() {
    // Removidos os parênteses vazios daqui de fora
    CarteirinhaDigitalTheme {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController
        )
    }
}