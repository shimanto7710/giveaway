package com.rookie.giveaway

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rookie.giveaway.ui.theme.GiveawayTheme
import kotlinx.coroutines.delay

class SplashScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiveawayTheme {
                // A surface container using the 'background' color from the theme

                SplashScreen()
            }
        }
    }

    @Preview
    @Composable
    private fun SplashScreen() {

        val alpha= remember {
            Animatable(0f)
        }

        LaunchedEffect(key1 = true ) {
            alpha.animateTo(1f, animationSpec = tween(1500))

            delay(1000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))

        }

        Box(modifier = Modifier.fillMaxSize().background(color = Color.White).alpha(alpha.value), contentAlignment = Alignment.Center){
            Text(text = "GiveAway", style = TextStyle(fontSize = 60.sp))
        }
    }
}
