package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun NetTabRow() {
    val tabItems = listOf("Personal", "Business", "Merchant")
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedIndex) {
        pagerState.animateScrollToPage(selectedIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedIndex = pagerState.currentPage
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color(20, 61, 89, 255),
            indicator = @Composable { tabPositions ->
                if (selectedIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                        color = Color.White
                    )
                }
            }
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    },
                    text = {
                        Text(text = item, fontSize = 17.sp)
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color(166, 168, 173, 255)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { index ->
            Box(modifier = Modifier.fillMaxSize()) {
                var filledText by remember {
                    mutableStateOf("")
                }
                val keyboardController = LocalSoftwareKeyboardController.current

                Column {

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Spacer(
                            modifier = Modifier
                                .width(30.dp)
                        )

                        val otfColor = Color(176, 185, 188, 255)

                        OutlinedTextField(
                            modifier = Modifier
                                .width(280.dp)
                                .height(50.dp),
                            value = filledText,
                            shape = RoundedCornerShape(33.dp),
                            onValueChange = { filledText = it },
                            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start),
                            placeholder = { Text(text = "Search") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Search,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
                                if (filledText.isNotEmpty())
                                    Icon(imageVector = Icons.Default.Close,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            filledText = ""
                                        }
                                    )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    keyboardController?.hide()
                                }
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = otfColor,
                                unfocusedBorderColor = otfColor,
                                unfocusedPlaceholderColor = otfColor,
                                focusedPlaceholderColor = otfColor,
                                focusedLeadingIconColor = otfColor,
                                unfocusedLeadingIconColor = otfColor,
                                focusedTrailingIconColor = otfColor,
                                unfocusedTrailingIconColor = otfColor
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .width(25.dp)
                        )
                        Icon(
                            modifier = Modifier.size(38.dp),
                            imageVector = Icons.Default.Tune,
                            contentDescription = null
                        )

                    }
                    Spacer(modifier = Modifier.height(13.dp))
                    val listx = listOf(
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        "hellou",
                        )
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        items(listx) {
                            when (index) {
                                0 -> NetPersonalCard()
                                1 -> NetBusinessCard()
                                else -> NetMerchantCard()
                            }
                        }
                    }
                }
                //get listcard of particular index

            }
        }

    }
}