package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NetPersonalCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {

        Row {
            Spacer(modifier = Modifier.width(30.dp))
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 35.dp)) {
                    Spacer(modifier = Modifier.height(130.dp))
                    Text(text = "Coffee | Business | Friendship",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(23,60,90,255))
                    Text(text = "Hi community! I am open  to new connections " + "\"😊\"",
                        fontSize = 14.sp,
                        color = Color(70,96,108,255,),
                        lineHeight = 15.sp
                    )

                }


            }
        }


        Row {
            Spacer(modifier = Modifier.width(12.dp))
            Card(
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .height(88.dp)
                    .width(80.dp),
                colors = CardDefaults.cardColors(containerColor = Color(184, 197, 205, 255)),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Text(
                        text = "AI",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(23,60,90,255)
                    )
                }
            }
            Spacer(modifier = Modifier.width(30.dp))

            Column(modifier = Modifier.padding(vertical = 38.dp)) {
                Text(text = "Amaan Inayat",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(23,60,90,255))

                Text(text = "Raipur | Student",
                    fontSize = 15.sp,
                    color = Color(70,96,108,255))

                Text(text = "Within 1.5 KM",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(23,55,80,255))

                Spacer(modifier = Modifier.height(5.dp))

                LinearProgressIndicator(
                    progress = 0.67f,
                    modifier = Modifier
                        .height(10.dp)
                        .width(120.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    color = Color(116,133,143,255),
                    trackColor = Color.Gray.copy(alpha = 0.5f)
                )

            }

            Spacer(modifier = Modifier.width(60.dp))

            Text(modifier = Modifier.padding(vertical = 15.dp),
                text = "+ INVITE",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(23,60,90,255))
        }
    }
}