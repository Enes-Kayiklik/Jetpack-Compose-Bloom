package com.eneskayiklik.bloom.screen.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable

@Composable
fun BloomBottomBar() {
    BottomNavigation {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            label = { Text(text = "Home") },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text(text = "Favorite") },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite") })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text(text = "Profile") },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile"
                )
            })
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text(text = "Cart") },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "ShoppingCart"
                )
            })
    }
}