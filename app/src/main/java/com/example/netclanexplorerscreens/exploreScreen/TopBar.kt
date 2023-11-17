package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.netclanexplorerscreens.R
import com.example.netclanexplorerscreens.navigation.NetScreens
import com.example.netclanexplorerscreens.ui.theme.AppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetTopBar(scope: CoroutineScope,
              drawerState: DrawerState,
              navController: NavHostController) {
    val topColor =
        TopAppBarDefaults.mediumTopAppBarColors(
            AppBar,
            AppBar,
            Color.White,
            Color.White,
            AppBar
        )

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    modifier = Modifier.size(38.dp),
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(30.dp))

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Howdy User101 !!",
                        color = Color.White,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            },
                            modifier = Modifier
                                .size(17.dp)) {
                            Icon(
                                modifier = Modifier
                                    .size(15.dp),
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "menu",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = " your location",
                            color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(120.dp))

            }

        },
        actions = {
            IconButton(
                onClick = {
                },
                modifier = Modifier.size(70.dp)
            ) {
                Column(
                    modifier = Modifier.clickable { navController.navigate(NetScreens.RefineScreen.name) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painterResource(R.drawable.checklist),
                        contentDescription = "list",
                        modifier = Modifier.width(28.dp)
                    )
                    Text(
                        text = "Refine",
                        color = Color.White,
                        style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp)
                    )
                }
            }
        },
        colors = topColor
    )

}
