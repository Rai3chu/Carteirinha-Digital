package com.senai.carteirinhadigital.app.navegation

sealed class Routes (val route: String){

     data object Login : Routes("login")
     data object Carteirinha : Routes("carteirinha")

     data object Home : Routes("home")
}