package com.senai.carteirinhadigital.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rafaelcosta.carteirinhadigital2devest.feature.login.presentation.factory.LoginViewModelFactory
import com.senai.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeProfScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.senai.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senai.carteirinhadigital.feature.turmas.presetation.screen.TurmasScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UcProfScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UnidadeCurricularScreen
import com.senaisp.carteirinhadigital.app.CarteirinhaApplication
import com.senaisp.carteirinhadigital.app.session.SessionViewModel


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
            // 1. Obtém o container de dependências a partir da Application
            val context = LocalContext.current
            val appContainer = (context.applicationContext as CarteirinhaApplication).container

            // 2. Cria o ViewModel utilizando a Factory
            val viewModel: LoginViewModel = viewModel(
                factory = LoginViewModelFactory(appContainer.loginRepository)
            )

            // 3. Passa o viewModel já instanciado para a tela
            LoginScreen(
                viewModel = viewModel,
                onProfessorClick = {
                    navController.navigate(Routes.HomeProf.route)
                },
                onLoginSucesso = { usuario ->
                    sessionViewModel.salvarUsuario(usuario)
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