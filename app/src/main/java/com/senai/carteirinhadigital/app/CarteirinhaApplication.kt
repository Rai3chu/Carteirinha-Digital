package com.senaisp.carteirinhadigital.app

import android.app.Application
import com.senaisp.carteirinhadigital.app.di.AppContainer
import com.senaisp.carteirinhadigital.app.di.DefaultAppContainer

class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}