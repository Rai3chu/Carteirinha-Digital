package com.senai.carteirinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeProfScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.senai.carteirinhadigital.feature.turmas.presetation.screen.TurmasScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UcProfScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UnidadeCurricularScreen
import com.senaisp.carteirinhadigital.app.session.SessionViewModel
import com.senaisp.carteirinhadigital.feature.login.presentation.screen.LoginScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel()
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            val loginViewModel: LoginViewModel = viewModel()

            LoginScreen(
                viewModel = loginViewModel,
                onProfessorClick = {
                    navController.navigate(Routes.HomeProf.route)
                },
                onLoginSucesso = { usuario ->
                    // 1. Atualiza a sessão com o usuário retornado pela API
                    sessionViewModel.salvarUsuario(usuario) // <-- Ajuste o nome do método caso no seu ViewModel seja diferente (ex: updateUsuario, setUsuario)

                    // 2. Navega para a Home ou Carteirinha
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Home.route) {
            if (usuarioLogado == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Home.route) { inclusive = true }
                    }
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        composable(Routes.Carteirinha.route) {
            if (usuarioLogado == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Carteirinha.route) { inclusive = true }
                    }
                }
            } else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteirinhaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        composable(Routes.UnidadesCurriculares.route) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                UnidadeCurricularScreen(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

        composable(Routes.HomeProf.route) {
            HomeProfScreen(navController = navController)
        }

        composable(Routes.Turmas.route) {
            TurmasScreen(navController = navController)
        }

        composable(Routes.UcProf.route) {
            UcProfScreen(navController = navController)
        }
    }
}