package com.example.netclanexplorerscreens.exploreScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netclanexplorerscreens.R

@Preview
@Composable
fun NetBusinessCard() {
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
                    Spacer(modifier = Modifier.height(135.dp))
                    Text(text = "Tutor | 12 year of experience",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(23,60,90,255))
                    Text(text = "Hi community! I am available at your service",
                        fontSize = 14.sp,
                        color = Color(70,96,108,255),
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
                        text = "TT",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(23,60,90,255)
                    )
                }
            }
            Spacer(modifier = Modifier.width(30.dp))

            Column(modifier = Modifier.padding(vertical = 38.dp)) {
                Text(text = "Terence Tao",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(23,60,90,255))

                Text(text = "Delhi, within 4.2 KM",
                    fontSize = 15.sp,
                    color = Color(70,96,108,255))
                Spacer(modifier = Modifier.height(5.dp))

                LinearProgressIndicator(
                    progress = 0.92f,
                    modifier = Modifier
                        .height(10.dp)
                        .width(120.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        ),
                    color = Color(116,133,143,255),
                    trackColor = Color.Gray.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(5.dp))

                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.call_circle),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(6.5.dp))
                    Image(modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.profile_circle),
                        contentDescription = null,
                        contentScale = ContentScale.Fit)
                }

            }

            Spacer(modifier = Modifier.width(50.dp))
            Text(modifier = Modifier.padding(vertical = 15.dp),
                text = "+ INVITE",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(23,60,90,255))
        }
    }
}