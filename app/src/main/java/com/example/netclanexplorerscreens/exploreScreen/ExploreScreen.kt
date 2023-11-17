package com.example.netclanexplorerscreens.exploreScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.netclanexplorerscreens.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExploreScreen(navController: NavHostController) {

    val items = getItems()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    border = BorderStroke(2.dp, Color.White),
                    shape = RectangleShape
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.drawer_bg),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                        Row {
                            Spacer(modifier = Modifier.width(27.dp))

                            Column {
                                Spacer(modifier = Modifier.height(15.dp))

                                Row(modifier = Modifier.fillMaxWidth()) {


                                    Card(
                                        shape = CircleShape,
                                        border = BorderStroke(1.dp, Color.White),
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.avatar),
                                            contentDescription = "avatar"
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(220.dp))

                                    IconButton(onClick = { }) {
                                        Icon(
                                            modifier = Modifier.size(28.dp),
                                            imageVector = Icons.Filled.Settings,
                                            contentDescription = "settings"
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(15.dp))
                                }

                                Column(modifier = Modifier.padding(start = 12.dp)) {
                                    Text(
                                        text = "User 101",
                                        color = Color.White,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "VVNOID0088050",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    LinearProgressIndicator(
                                        progress = 0.3f,
                                        modifier = Modifier
                                            .height(20.dp)
                                            .width(120.dp)
                                            .clip(
                                                RoundedCornerShape(10.dp)
                                            ),
                                        color = Color.White,
                                        trackColor = Color.Gray.copy(alpha = 0.5f)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Available",
                                        color = Color.White,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light
                                    )

                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.label) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                }
            }

        },
        drawerState = drawerState
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NetTopBar(scope, drawerState, navController)
            },
            bottomBar = {
                NetBottomBar()
            },
            floatingActionButton = {
                multiFab()
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                NetTabRow()
            }
        }
    }
}

