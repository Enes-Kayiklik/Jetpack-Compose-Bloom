package com.eneskayiklik.bloom.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.data.model.Bloom
import com.eneskayiklik.bloom.data.model.browseThemeList
import com.eneskayiklik.bloom.ui.theme.BloomTheme

@Composable
fun BrowseCard(item: Bloom) {
    Card(
        modifier = Modifier.size(136.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(
                    id = item.image
                ), contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp)
                    .wrapContentSize(align = CenterStart),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )
        }
    }
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
fun BrowsePrv() {
    BloomTheme {
        BrowseCard(browseThemeList.first())
    }
}