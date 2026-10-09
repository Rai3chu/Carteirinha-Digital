package com.senaisp.carteirinhadigital.app

import android.app.Application
import com.senai.carteirinhadigital.app.di.DefaultAppContainer
import com.senaisp.carteirinhadigital.app.di.AppContainer


class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}