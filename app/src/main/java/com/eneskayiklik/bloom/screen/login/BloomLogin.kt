package com.eneskayiklik.bloom.screen.login

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.R
import com.eneskayiklik.bloom.component.BloomButton
import com.eneskayiklik.bloom.component.BloomTextField
import com.eneskayiklik.bloom.ui.theme.BloomTheme

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginTitle(modifier = Modifier.paddingFromBaseline(184.dp))
            Spacer(modifier = Modifier.height(16.dp))
            BloomTextField(label = "Email address")
            Spacer(modifier = Modifier.height(8.dp))
            BloomTextField(
                label = "Password (8+ characters)",
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TermsText()
            Spacer(modifier = Modifier.height(16.dp))
            BloomButton(text = stringResource(id = R.string.log_in))
        }
    }
}

@Composable
private fun LoginTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Log in with email",
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onSurface,
        modifier = modifier
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun PrevLogin() {
    BloomTheme {
        LoginScreen()
    }
}