package com.eneskayiklik.bloom.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.data.model.Bloom
import com.eneskayiklik.bloom.data.model.homeGardenList
import com.eneskayiklik.bloom.ui.theme.BloomTheme

@Composable
fun HomeGardenCard(item: Bloom) {
    var isSelected by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .clickable { isSelected = !isSelected }
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp)
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .align(Alignment.BottomCenter),
            )
            Checkbox(
                checked = isSelected,
                onCheckedChange = { isSelected = isSelected.not() },
                modifier = Modifier.align(Alignment.CenterEnd),
                colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.primary)
            )
            Text(
                text = item.title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .paddingFromBaseline(24.dp)
                    .padding(8.dp)
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .paddingFromBaseline(40.dp)
                    .padding(start = 8.dp)
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
fun HomeGardenCardPrv() {
    BloomTheme {
        HomeGardenCard(homeGardenList.first())
    }
}