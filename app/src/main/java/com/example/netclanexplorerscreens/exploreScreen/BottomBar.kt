package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netclanexplorerscreens.R

data class BottomNavItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter
)

@Composable
fun NetBottomBar() {

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }


    val items = listOf(
        BottomNavItem(
            "Explore",
            painterResource(R.drawable.baseline_visibility_24),
            painterResource(R.drawable.outline_visibility_24)
        ),
        BottomNavItem(
            "Network",
            painterResource(R.drawable.baseline_radar_24),
            painterResource(R.drawable.outline_radar_24)
        ),
        BottomNavItem(
            "Chat",
            painterResource(R.drawable.baseline_chat_24),
            painterResource(R.drawable.outline_chat_24)
        ),
        BottomNavItem(
            "Contacts",
            painterResource(R.drawable.baseline_contact_page_24),
            painterResource(R.drawable.outline_contact_page_24)
        ),
        BottomNavItem(
            "Groups",
            painterResource(R.drawable.baseline_tag_24),
            painterResource(R.drawable.outline_tag_24)
        ),
    )

    NavigationBar(containerColor = Color.White) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                label = {
                    Text(
                        text = item.title,
                        fontSize = 13.sp,
                        fontWeight = if (index == selectedItemIndex) FontWeight.Bold else FontWeight.Normal,
                        color = if (index == selectedItemIndex) Color(
                            17,
                            58,
                            88,
                            255
                        ) else
                            Color(
                                114,
                                139,
                                152,
                                255
                            )
                    )
                },
                onClick = {
                    selectedItemIndex = index
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if (index == selectedItemIndex) Color(
                            17,
                            58,
                            88,
                            255
                        ) else
                            Color(
                                114,
                                139,
                                152,
                                255
                            )
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White)
            )
        }
    }
}
