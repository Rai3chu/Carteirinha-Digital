package com.senai.carteirinhadigital.feature.home.presentation.screen

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.senai.carteirinhadigital.R
import java.lang.reflect.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    Box{
        Image(
           painter = painterResource(id = R.drawable.fundo),
           contentDescription = "Fundo",
           modifier = Modifier
               .fillMaxSize()
               .alpha(0.5f),
           contentScale = ContentScale.Crop
        )

        Column(

        ) {

            Row(

            ) {

                Button(

                )
            }
        }
    }
}