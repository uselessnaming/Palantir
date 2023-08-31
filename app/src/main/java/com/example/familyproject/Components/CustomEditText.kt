package com.example.familyproject.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.familyproject.R

@Composable
fun CustomEditText(
    text : String = "",
    onValueChange : (String) -> Unit = {},
    modifier : Modifier,
    hint : String,
    fontFamily : FontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
    fontSize : TextUnit,
    color : Color,
){
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.padding(0.dp),
        textStyle = TextStyle(
            fontSize = fontSize,
            fontFamily = fontFamily,
            color = color
        ),
        decorationBox = {innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth()
            ){
                if (text.isEmpty()){
                    Text(
                        text = hint,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        color = color,
                    )
                }
                innerTextField()
            }
        }
//        placeholder = {
//            Text(
//                text = hint,
//                fontFamily = fontFamily,
//                lineHeight = lineHeight,
//                fontSize = fontSize,
//                color = color
//           )
//        },
//        colors = TextFieldDefaults.textFieldColors(
//            containerColor = Color.Transparent,
//        ),

    )
}