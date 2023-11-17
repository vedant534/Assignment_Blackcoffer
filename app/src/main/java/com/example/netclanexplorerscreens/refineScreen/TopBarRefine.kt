package com.example.netclanexplorerscreens.refineScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.netclanexplorerscreens.ui.theme.AppBarRefine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarRefine(navController: NavHostController) {
    val topColor =
        TopAppBarDefaults.mediumTopAppBarColors(
            AppBarRefine,
            AppBarRefine,
            Color.White,
            Color.White,
            AppBarRefine
        )
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = "back",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(32.dp))

                Text(
                    text = "Refine",
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 21.sp)
                )
            }
        },
        colors = topColor
    )
}