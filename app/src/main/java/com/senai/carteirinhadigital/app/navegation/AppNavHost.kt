package com.senai.carteirinhadigital.app.navegation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.senai.carteirinhadigital.app.session.SessionViewModel
import com.senai.carteirinhadigital.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeProfScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeProfScreen
import com.senai.carteirinhadigital.feature.home.presentation.screen.HomeScreen
import com.senai.carteirinhadigital.feature.login.presentation.screen.LoginScreen
import com.senai.carteirinhadigital.feature.turmas.domain.model.Turmas
import com.senai.carteirinhadigital.feature.turmas.presetation.screen.TurmasScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UcProfScreen
import com.senai.carteirinhadigital.feature.unidadescurriculares.presentation.screen.UnidadeCurricularScreen

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
        composable(Routes.Login.route) {  //Login
            LoginScreen(
                navController=navController
            )
        }
        composable(Routes.Carteirinha.route) {  //Carteirinha
            val usuario = usuarioLogado
            if (usuario==null){
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            }else {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

        composable(Routes.Home.route) {   //Home
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                HomeScreen(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )

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
