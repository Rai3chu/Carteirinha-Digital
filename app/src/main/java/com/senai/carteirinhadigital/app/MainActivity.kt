package com.senai.carteirinhadigital.app

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable // IMPORTANTE
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(0, WindowManager.LayoutParams.FLAG_SECURE)
        enableEdgeToEdge()

        val appContainer = (application as CarteirinhaApplication).container

        setContent {
            val systemInDark = isSystemInDarkTheme()

            // Troque remember por rememberSaveable
            var darkTheme by rememberSaveable { mutableStateOf(systemInDark) }

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