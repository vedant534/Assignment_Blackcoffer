package com.example.netclanexplorerscreens.refineScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sliderWithLabel() {
    var distanceValue by remember { mutableFloatStateOf(0f) }
    val valueRange = 0f..100f
    val labelMinWidth = 24.dp
    val interactionSource = remember { MutableInteractionSource() }

    Column {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            val offset = getSliderOffset(
                value = distanceValue,
                valueRange = valueRange,
                boxWidth = maxWidth,
                labelWidth = labelMinWidth + 8.dp // Since we use a padding of 4.dp on either sides of the SliderLabel, we need to account for this in our calculation
            )

            val endValueText = distanceValue.toInt().toString()


            SliderLabel(
                label = endValueText, minWidth = labelMinWidth, modifier = Modifier
                    .padding(start = offset)
            )

        }

        Slider(
            value = distanceValue, onValueChange = {
                distanceValue = it
            },
            valueRange = valueRange,
            modifier = Modifier.fillMaxWidth(),
            track = { sliderPositions ->
                SliderDefaults.Track(
                    modifier = Modifier.scale(scaleX = 1f, scaleY = 0.6f),
                    sliderPositions = sliderPositions,
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(23, 60, 90, 255),
                        inactiveTrackColor = Color.LightGray,
                    )
                )
            },
            thumb = {
                SliderDefaults.Thumb(
                    modifier = Modifier.scale(scaleX = 0.7f, scaleY = 0.7f),
                    interactionSource = interactionSource,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(23, 60, 90, 255)
                    )
                )
            }
        )

        Row() {
            Text(
                text = "${valueRange.start.toInt()} km", fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(23, 60, 90, 255),
            )
            Spacer(modifier = Modifier.width(260.dp))
            Text(
                text = "${valueRange.endInclusive.toInt()} km", fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(23, 60, 90, 255) ,
            )
        }

    }
}


@Composable
fun SliderLabel(label: String, minWidth: Dp, modifier: Modifier = Modifier) {
    Text(
        label,
        fontSize = 13.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = modifier
            .background(
                color = Color(23, 60, 90, 255),
                shape = RoundedCornerShape(2.dp)
            )
            .padding(4.dp)
            .defaultMinSize(minWidth = minWidth)
    )
}


private fun getSliderOffset(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    boxWidth: Dp,
    labelWidth: Dp
): Dp {

    val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
    val positionFraction = calcFraction(valueRange.start, valueRange.endInclusive, coerced)

    return (boxWidth - labelWidth) * positionFraction
}


// Calculate the 0..1 fraction that `pos` value represents between `a` and `b`
private fun calcFraction(a: Float, b: Float, pos: Float) =
    (if (b - a == 0f) 0f else (pos - a) / (b - a)).coerceIn(0f, 1f)