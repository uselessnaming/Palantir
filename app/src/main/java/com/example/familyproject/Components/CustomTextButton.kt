package com.example.familyproject.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.familyproject.R

@Composable
fun CustomTextButton(
    modifier : Modifier,
    content : String,
    textColor : Color,
    fontSize : TextUnit,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
){
    Text(
        text = content,
        modifier = modifier,
        fontSize = fontSize,
        color = textColor,
        fontFamily = fontFamily,
        fontWeight = FontWeight(500)
    )
}