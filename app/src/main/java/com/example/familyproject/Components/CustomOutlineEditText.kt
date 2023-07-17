package com.example.familyproject.Components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.familyproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlineEditText(
    modifier : Modifier,
    hint : String,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    fontSize : TextUnit,
    borderColor : TextFieldColors,
    borderShape : Shape,
    textColor : Color,
    onValueChange : (String) -> Unit = {},
    visualTransformation : VisualTransformation = VisualTransformation.None,
    value : String = "",
    keyboardActions : KeyboardActions = KeyboardActions.Default,
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default
){
    OutlinedTextField(
        onValueChange = onValueChange,
        value = value,
        modifier = modifier,
        singleLine = true,
        placeholder = { Text(
            modifier = Modifier.padding(0.dp)
                .height(16.dp),
            text = hint,
            fontFamily = fontFamily,
            fontSize = fontSize,
            color = textColor)
        },
        colors = borderColor,
        shape = borderShape,
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
    )
}