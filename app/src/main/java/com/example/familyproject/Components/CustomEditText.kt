package com.example.familyproject.Components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import com.example.familyproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEditText(
    text : String = "",
    onValueChange : (String) -> Unit = {},
    modifier : Modifier,
    hint : String,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    fontSize : TextUnit,
    color : Color,
    lineHeight : TextUnit = fontSize
){
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = {
            Text(
                text = hint,
                fontFamily = fontFamily,
                lineHeight = lineHeight,
                fontSize = fontSize,
                color = color
           )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
    )
}