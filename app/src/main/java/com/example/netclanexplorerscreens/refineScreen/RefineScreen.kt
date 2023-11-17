@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.netclanexplorerscreens.refineScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RefineScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Scaffold(topBar = {
        TopBarRefine(navController)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            RefineContent(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun RefineContent(navController: NavHostController) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Select Your Availability", fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(23, 60, 90, 255)
        )
        Spacer(modifier = Modifier.height(10.dp))
        var isExpanded by remember {
            mutableStateOf(false)
        }
        var option by remember {
            mutableStateOf("Available | Hey Let Us Connect")
        }
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }) {
            OutlinedTextField(
                value = option,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                ),
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color(25, 58, 80, 255),
                    unfocusedTextColor = Color(25, 58, 80, 255),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
            )
            ExposedDropdownMenu(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(),
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
            ) {
                val ddFontSize = 17.sp
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Available | Hey Let Us Connect",
                            fontWeight = FontWeight.Normal,
                            fontSize = ddFontSize,
                            textAlign = TextAlign.Start,
                        )
                    },
                    onClick = {
                        option = "Available | Hey Let Us Connect"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(textColor = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Away | Stay Discrete And Watch",
                            fontWeight = FontWeight.Normal,
                            fontSize = ddFontSize,
                            textAlign = TextAlign.Start,
                        )
                    },
                    onClick = {
                        option = "Away | Stay Discrete And Watch"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(textColor = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Busy | Do Not Disturb | Will Catch Up Later",
                            fontWeight = FontWeight.Normal,
                            fontSize = ddFontSize,
                            textAlign = TextAlign.Start,
                        )
                    },
                    onClick = {
                        option = "Busy | Do Not Disturb | Will Catch Up Later"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(textColor = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "SOS | Emergency! Need Assistance! Help",
                            fontWeight = FontWeight.Normal,
                            fontSize = ddFontSize,
                            textAlign = TextAlign.Start,
                        )
                    },
                    onClick = {
                        option = "SOS | Emergency! Need Assistance! Help"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(textColor = Color.Black),
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Add Your Status", fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(23, 60, 90, 255)
        )
        Spacer(modifier = Modifier.height(10.dp))

        val keyboardController = LocalSoftwareKeyboardController.current
        var filledText by remember {
            mutableStateOf("Hi community! I am open  to new connections " + "\"😊\"")
        }
        val maxChar = 250

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = filledText,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                if (it.length <= maxChar) filledText = it
            },
            textStyle = TextStyle(textAlign = TextAlign.Start, fontSize = 13.sp),
            placeholder = { Text(text = "Enter Status Here") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    filledText = "$filledText\n"
                }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(25, 58, 80, 255),
                unfocusedTextColor = Color(25, 58, 80, 255),
            ),
            maxLines = 120
        )

        Box(modifier = Modifier.align(Alignment.End)) {
            Text(
                text = "${filledText.length}/${maxChar}",
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Select Hyper Local Distance", fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(23, 60, 90, 255)
        )

        Spacer(modifier = Modifier.height(10.dp))
        sliderWithLabel()

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Select Purpose", fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(23, 60, 90, 255)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row {
            ToggleBtn(label = "Coffee")
            Spacer(modifier = Modifier.width(9.dp))
            ToggleBtn(label = "Business")
            Spacer(modifier = Modifier.width(9.dp))
            ToggleBtn(label = "Hobbies")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            ToggleBtn(label = "Friendship")
            Spacer(modifier = Modifier.width(9.dp))
            ToggleBtn(label = "Movies")
            Spacer(modifier = Modifier.width(9.dp))
            ToggleBtn(label = "Dinning")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            ToggleBtn(label = "Dating")
            Spacer(modifier = Modifier.width(9.dp))
            ToggleBtn(label = "Matrimony")
        }
        Spacer(modifier = Modifier.height(22.dp))

        Row{
            Spacer(modifier = Modifier.width(67.dp))
            Button(
                modifier = Modifier
                    .width(225.dp)
                    .height(40.dp),
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(23, 60, 90, 255),
                    contentColor = Color.White,
                )
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Save and Explore",
                        fontSize = 15.sp)
                }
            }
        }
    }
}


@Composable
fun ToggleBtn(label: String) {

    var onState by remember {
        mutableStateOf(false)
    }
    OutlinedButton(
        onClick = { onState = !onState },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (onState) Color(23, 60, 90, 255) else Color.White,
            contentColor = if (!onState) Color(23, 60, 90, 255) else Color.White,
        ),
        border = BorderStroke(1.dp, color = Color(23, 60, 90, 255)),
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = label)
        }
    }
}



