package com.eneskayiklik.bloom.data.model

import androidx.annotation.DrawableRes
import com.eneskayiklik.bloom.R

data class Bloom(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String = ""
)

val browseThemeList = listOf(
    Bloom(
        image = R.drawable.desert_chic,
        title = "Desert chic"
    ),
    Bloom(
        image = R.drawable.tiny_terrarium,
        title = "Tiny terrariums"
    ),
    Bloom(
        image = R.drawable.jungle_vibe,
        title = "Jungle vibe"
    )
)

val homeGardenList = listOf(
    Bloom(
        image = R.drawable.monstera,
        title = "Monstera",
        description = "This is a description"
    ),
    Bloom(
        image = R.drawable.aglaonema,
        title = "Aglaonema",
        description = "This is a description"
    ),
    Bloom(
        image = R.drawable.peace_lily,
        title = "Peace lily",
        description = "This is a description"
    ),
    Bloom(
        image = R.drawable.fiddle_leaf,
        title = "Fiddle leaf tree",
        description = "This is a description"
    )
)