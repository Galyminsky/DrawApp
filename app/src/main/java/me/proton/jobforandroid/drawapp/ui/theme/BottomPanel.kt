package me.proton.jobforandroid.drawapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomPanel() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        ColorList()
    }
}

@Composable
fun ColorList() {
    val colors = listOf(
        Color.Red,
        Color.Green,
        Color.Yellow,
        Color.Black,
        Color.Blue,
        Color.Magenta,
        Color.Cyan,
        Color.White,
        Color.Gray,
    )

    LazyRow(
        modifier = Modifier.padding(10.dp)
    )
    {
        items(colors) { color ->
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                    }
                    .size(40.dp)
                    .background(color, CircleShape)
            ) {

            }
        }
    }
}