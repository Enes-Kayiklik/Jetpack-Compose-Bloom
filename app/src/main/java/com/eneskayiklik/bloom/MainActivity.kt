package com.eneskayiklik.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import com.eneskayiklik.bloom.screen.home.HomeScreen
import com.eneskayiklik.bloom.screen.login.LoginScreen
import com.eneskayiklik.bloom.screen.welcome.WelcomeScreen
import com.eneskayiklik.bloom.ui.theme.BloomTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            BloomTheme {
                AnimatedNavHost(navController = navController, startDestination = "welcome") {
                    composable(
                        "welcome",
                        exitTransition = { _, _ ->
                            shrinkHorizontally(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeOut(animationSpec = tween(300))
                        },
                        popEnterTransition = { _, _ ->
                            expandHorizontally(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeIn(animationSpec = tween(300))
                        },
                    ) {
                        WelcomeScreen(navController)
                    }
                    composable(
                        "login",
                        popEnterTransition = { _, _ ->
                            expandHorizontally(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeIn(animationSpec = tween(300))
                        },
                        exitTransition = { _, _ ->
                            shrinkHorizontally(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeOut(animationSpec = tween(300))
                        },
                        popExitTransition = null
                    ) {
                        LoginScreen(navController)
                    }
                    composable(
                        "home",
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}