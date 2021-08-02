package com.eneskayiklik.bloom.screen.login

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@Composable
fun TermsText() {
    val text = buildAnnotatedString {
        append("By clicking below, you agree to our ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Terms of Use")
        }
        append(" and consent to our ")
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("Privacy Policy")
        }
    }

    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.onSurface,
        textAlign = TextAlign.Center
    )
}