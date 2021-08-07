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
                            slideOutHorizontally(
                                targetOffsetX = { -300 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeOut(animationSpec = tween(300))
                        },
                        popEnterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { -300 },
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
                        enterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { 300 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeIn(animationSpec = tween(300))
                        },
                        popEnterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { -300 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeIn(animationSpec = tween(300))
                        },
                    ) {
                        LoginScreen(navController)
                    }
                    composable(
                        "home",
                        enterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { 300 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = FastOutSlowInEasing
                                )
                            ) + fadeIn(animationSpec = tween(300))
                        },
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}