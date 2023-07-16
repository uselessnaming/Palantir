package com.example.familyproject.Components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

/** Row 혹은 Col을 선택했을 때 만약 startX, startY, endX, endY 중 필요한 값이 NULL 일 경우 NullPointerException 오류를 throw해야 함*/

@Composable
fun CustomLine(
    modifier : Modifier,
    type : String,
    strokeWidth : Float,
    color : Color = Color.Gray,
    startX : Float? = null,
    startY : Float? = null,
    endX : Float? = null,
    endY : Float? = null
){
    when (type) {
        "row" -> {
            Canvas(modifier = modifier){
                drawLine(
                    start = Offset(startX!!,size.height),
                    end = Offset(endX!!,size.height),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
        "col" -> {
            Canvas(modifier = modifier){
                drawLine(
                    start = Offset(size.width,startY!!),
                    end = Offset(size.width,endY!!),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
        "fully row" -> {
            Canvas(modifier = Modifier.fillMaxWidth()){
                drawLine(
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
        "fully col" -> {
            Canvas(modifier = Modifier.fillMaxHeight()){
                drawLine(
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
        else -> {
            Canvas(modifier = modifier){
                drawLine(
                    start = Offset(startX!!,startY!!),
                    end = Offset(endX!!,endY!!),
                    color = color,
                    strokeWidth = strokeWidth
                )
            }
        }
    }
}