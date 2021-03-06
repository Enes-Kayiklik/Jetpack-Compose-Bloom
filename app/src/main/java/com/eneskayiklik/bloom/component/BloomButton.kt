package com.eneskayiklik.bloom.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.ui.theme.Shapes

@Composable
fun BloomButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    backgroundColor: Color = MaterialTheme.colors.secondary
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
    ) {
        Text(text = text)
    }
}

@Composable
fun BloomTextButton(
    text: String,
    onClick: () -> Unit = { }
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(start = 16.dp, end = 16.dp),
    ) {
        Text(text = text, color = MaterialTheme.colors.secondary)
    }
}