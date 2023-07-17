package com.example.familyproject.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import com.example.familyproject.R

@Composable
fun CustomButton(
    modifier : Modifier,
    onClick : () -> Unit,
    content : String,
    contentFont : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    contentSize : TextUnit,
    contentPadding : PaddingValues,
    contentColor : Color,
    containerColor : Color
){
    Box(
        modifier = modifier
    ){
        Button(
            modifier = Modifier.fillMaxSize(),
            onClick = onClick,
            contentPadding = contentPadding,
            colors = ButtonDefaults.buttonColors(containerColor = containerColor, contentColor = contentColor)
        ){
            Text(
                text = content,
                fontSize = contentSize,
                fontFamily = contentFont,
            )
        }
    }
}