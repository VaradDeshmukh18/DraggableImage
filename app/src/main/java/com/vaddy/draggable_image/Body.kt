package com.vaddy.draggable_image

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun Body(){

    var offsetX by remember {
        mutableStateOf(0f)
    }

    var offsetY by remember {
        mutableStateOf(0f)
    }



    // Limit dragging
//    var maxDragDp = 60.dp
//    var density = LocalDensity.current
//    var maxDragPx = with(density){
//        maxDragDp.toPx()
//    }



    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        val brush = Brush.horizontalGradient(
            listOf(
                Color(0xFF00F5A0),
                Color(0xFF00D9F5)
            )
        )

        Canvas(
            modifier = Modifier.size(210.dp),
            onDraw = {

                drawCircle(brush=brush)
            },


        )

        Image(
            painter = painterResource(id = R.drawable.slice),
            contentDescription = "pizza",
            modifier = Modifier
                .size(260.dp)
                .offset {
                    IntOffset(
                        offsetX.roundToInt(),
                        offsetY.roundToInt()
                    )
                }
                .pointerInput(Unit){
                    detectDragGestures(
                        onDrag = {change, dragAmount ->

//                            var limitX = (offsetX + dragAmount.x).coerceIn(-maxDragPx,maxDragPx)
//                            var limitY = (offsetX + dragAmount.y).coerceIn(-maxDragPx,maxDragPx)

                            offsetX +=dragAmount.x
                            offsetY +=dragAmount.y
                        },
                        onDragEnd = {
                            offsetX=0f
                            offsetY=0f
                        }
                    )
                }

        )
        
    }
}


//@Preview
//@Composable
//fun prev(){
//    Body()
//}