package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.netclanexplorerscreens.R
import com.example.netclanexplorerscreens.expandFab.FabIcon
import com.example.netclanexplorerscreens.expandFab.FabOption
import com.example.netclanexplorerscreens.expandFab.MultiFloatingActionButton

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun multiFab() {
    val context = LocalContext.current
    MultiFloatingActionButton(
        items = listOf(
            IconItem(
                id = 1,
                iconRes = R.drawable.heart,
                label = "Dating"
            ),
            IconItem(
                id = 2,
                iconRes = R.drawable.dance,
                label = "Matrimony"
            ),
            IconItem(
                id = 3,
                iconRes = R.drawable.exchange,
                label = "Buy-Sell-Rent"
            ),
            IconItem(
                id = 4,
                iconRes = R.drawable.bizcard,
                label = "Business Cards"
            ),
            IconItem(
                id = 5,
                iconRes = R.drawable.teamwork,
                label = "Netclan Groups"
            ),
            IconItem(
                id = 6,
                iconRes = R.drawable.recruitment,
                label = "Jobs"
            ),
            IconItem(
                id = 4,
                iconRes = R.drawable.wirte,
                label = "Notes"
            )

        ),
        fabIcon = FabIcon(iconRes = R.drawable.ic_baseline_add_24, iconRotate = 45f),
        onFabItemClicked = {
        },
        fabOption = FabOption(
            iconTint = Color.White,
            showLabel = true
        )
    )
}