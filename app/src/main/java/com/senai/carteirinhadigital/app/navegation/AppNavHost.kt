package com.senai.carteirinhadigital.app.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.login.presentation.screen.LoginScreen

@Composable
fun AppNavHost(
    navController: NavController
) {

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {

        composable(Routes.Login.route) {
            LoginScreen()
        }

        composable(Routes.Carteirinha.route) {
            CarteirinhaScreen()
        }
    }
}