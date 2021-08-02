package com.eneskayiklik.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eneskayiklik.bloom.screen.login.LoginScreen
import com.eneskayiklik.bloom.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                LoginScreen()
            }
        }
    }
}