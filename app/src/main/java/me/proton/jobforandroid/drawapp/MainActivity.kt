package me.proton.jobforandroid.drawapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import me.proton.jobforandroid.drawapp.ui.theme.BottomPanel
import me.proton.jobforandroid.drawapp.ui.theme.DrawAppTheme
import me.proton.jobforandroid.drawapp.ui.theme.PathData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val pathData = remember {
                mutableStateOf(PathData())
            }
            DrawAppTheme {
                Column {
                    DrawCanvas(pathData)
                    BottomPanel() { color ->
                        pathData.value = pathData.value.copy(
                            color = color
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun DrawCanvas(pathData: MutableState<PathData>) {

    var tempPath = Path()
    val pathList = remember {
        mutableStateListOf(PathData())
    }

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.75f)
        .pointerInput(true) {
            detectDragGestures(
                onDragStart = {
                    tempPath = Path()
                }
            ) { change, dragAmount ->
                tempPath.moveTo(
                    change.position.x - dragAmount.x,
                    change.position.y - dragAmount.y
                )

                tempPath.lineTo(
                    change.position.x,
                    change.position.y
                )

                pathList.add(
                    pathData.value.copy(
                        path = tempPath
                    )
                )

            }
        }
    ) {
        pathList.forEach { PathData ->
            drawPath(
                PathData.path,
                color = PathData.color,
                style = Stroke(5f)
            )
        }
    }
}