package com.example.netclanexplorerscreens.exploreScreen

import androidx.annotation.DrawableRes

data class IconItem(
    val id: Int,
    @DrawableRes val iconRes: Int,
    val label: String = ""
)
