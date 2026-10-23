package com.senai.carteirinhadigital.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.senaisp.carteirinhadigital.app.CarteirinhaApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val appContainer = (application as CarteirinhaApplication).container

        setContent {
            // Estado para controlar o tema claro/escuro
            val systemInDark = isSystemInDarkTheme()
            var darkTheme by remember { mutableStateOf(systemInDark) }

            App(
                container = appContainer,
                darkTheme = darkTheme,
                onDarkThemeChange = { isDark ->
                    darkTheme = isDark
                }
            )
        }
    }
}