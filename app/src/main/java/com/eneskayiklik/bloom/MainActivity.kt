package com.eneskayiklik.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eneskayiklik.bloom.screen.home.HomeScreen
import com.eneskayiklik.bloom.screen.login.LoginScreen
import com.eneskayiklik.bloom.screen.welcome.WelcomeScreen
import com.eneskayiklik.bloom.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BloomTheme {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(navController)
                    }
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("home") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}