package com.senai.carteirinhadigital.app.navegation

sealed class Routes(val route: String) {

     object Login : Routes("login")
     object Carteirinha : Routes("carteirinha")
}