package com.example.familyproject.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.White

@Composable
fun CustomOutlineButton(
    modifier : Modifier,
    backgroundColor : ButtonColors = ButtonDefaults.buttonColors(White),
    border : BorderStroke = BorderStroke(width = 0.dp, color = Color.Transparent),
    content : String,
    contentSize : TextUnit,
    contentColor : Color,
    contentPadding : PaddingValues,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    fontWeight : FontWeight = FontWeight(400),
    onClick : () -> Unit,
){
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = contentPadding,
        colors = backgroundColor,
        border = border
    ){
        Text(
            text = content,
            fontSize = contentSize,
            color = contentColor,
            fontFamily = fontFamily,
            fontWeight = fontWeight
        )
    }
}