package com.eneskayiklik.bloom.screen.welcome

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.R
import com.eneskayiklik.bloom.component.BloomButton
import com.eneskayiklik.bloom.component.BloomTextButton
import com.eneskayiklik.bloom.ui.theme.BloomTheme

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
    ) {
        val isLight = MaterialTheme.colors.isLight
        WelcomeBackground(isLight)
        WelcomeForeground(isLight)
    }
}

@Composable
private fun WelcomeForeground(isLight: Boolean) {
    Column(
        modifier = Modifier.padding(top = 72.dp)
    ) {
        WelcomeForegroundIcon(isLight)
        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = if (isLight)
                painterResource(id = R.drawable.ic_light_logo)
            else painterResource(id = R.drawable.ic_dark_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.welcome_title),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 32.dp),
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(40.dp))
        BloomButton(text = stringResource(id = R.string.create_account))
        Spacer(modifier = Modifier.height(8.dp))
        BloomTextButton(
            text = stringResource(id = R.string.log_in)
        )
    }
}

@Composable
private fun WelcomeForegroundIcon(isLight: Boolean) {
    val foregroundIcon =
        if (isLight) painterResource(id = R.drawable.ic_light_welcome_illos) else
            painterResource(id = R.drawable.ic_dark_welcome_illos)
    Image(
        painter = foregroundIcon,
        contentDescription = stringResource(id = R.string.welcome_fore_description),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .absolutePadding(left = 88.dp)
            .offset(48.dp)
    )
}

@Composable
private fun WelcomeBackground(isLight: Boolean) {
    val backgroundImage =
        if (isLight) painterResource(id = R.drawable.ic_light_welcome_bg) else
            painterResource(id = R.drawable.ic_dark_welcome_bg)
    Image(
        painter = backgroundImage,
        contentDescription = stringResource(id = R.string.welcome_back_description),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
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
fun WelcomePreview() {
    BloomTheme {
        WelcomeScreen()
    }
}