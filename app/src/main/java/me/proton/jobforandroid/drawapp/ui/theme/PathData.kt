package me.proton.jobforandroid.drawapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap

data class PathData(
    val path: Path = Path(),
    val color: Color = Color.Red,
    val lineWidth: Float = 5f,
    val cap: StrokeCap = StrokeCap.Round,
)
