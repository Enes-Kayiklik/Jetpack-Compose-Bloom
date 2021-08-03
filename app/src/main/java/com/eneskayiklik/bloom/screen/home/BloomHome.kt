package com.eneskayiklik.bloom.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskayiklik.bloom.component.BloomTextField
import com.eneskayiklik.bloom.data.model.browseThemeList
import com.eneskayiklik.bloom.data.model.homeGardenList
import com.eneskayiklik.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), backgroundColor = MaterialTheme.colors.background
    ) {
        LazyColumn {
            // search box
            item {
                Spacer(modifier = Modifier.height(40.dp))
                BloomTextField(label = "Search", leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            }
            // browse title
            item {
                HomeTitle(title = "Browse themes", modifier = Modifier.paddingFromBaseline(32.dp))
                Spacer(modifier = Modifier.height(16.dp))
            }
            // browse items
            item {
                LazyRow {
                    itemsIndexed(browseThemeList) { index, item ->
                        if (index == 0)
                            Spacer(modifier = Modifier.width(16.dp))
                        else
                            Spacer(modifier = Modifier.width(8.dp))
                        BrowseCard(item = item)
                    }
                }
            }
            item {
                HomeTitle(
                    title = "Design your home garden",
                    endIcon = Icons.Default.FilterList,
                    modifier = Modifier.paddingFromBaseline(40.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            itemsIndexed(homeGardenList) { index, item ->
                if (index == 0)
                    Spacer(modifier = Modifier.height(16.dp))
                else
                    Spacer(modifier = Modifier.height(8.dp))
                HomeGardenCard(item = item)
            }
        }
    }
}

@Composable
private fun HomeTitle(
    title: String,
    modifier: Modifier = Modifier,
    endIcon: ImageVector? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
        )

        if (endIcon != null) {
            Image(
                imageVector = endIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground)
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
fun HomeScreenPrv() {
    BloomTheme {
        HomeScreen()
    }
}