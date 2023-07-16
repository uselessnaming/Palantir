package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.familyproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEditText(
    modifier : Modifier,
    hint : String,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    fontWeight : FontWeight = FontWeight(400),
    fontSize : TextUnit,
    color : Color
){
    var textState by remember{ mutableStateOf(("")) }

    TextField(
        onValueChange = {textState = it},
        value = textState,
        modifier = modifier,
        singleLine = true,
        placeholder = { Text(
            text = hint,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = color
        )},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
    )
}