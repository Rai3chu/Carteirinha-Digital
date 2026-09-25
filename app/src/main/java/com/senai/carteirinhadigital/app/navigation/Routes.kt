package com.senai.carteirinhadigital.app.navigation

sealed class Routes (val route: String){

     data object Login : Routes("login")
     data object Carteirinha : Routes("carteirinha")
     data object UnidadesCurriculares : Routes("unidadescurriculares")
     data object Home : Routes("home")

     data object HomeProf : Routes("homeProf")
     data object Turmas : Routes("turmas")
     data object UcProf : Routes("UcProf")
}