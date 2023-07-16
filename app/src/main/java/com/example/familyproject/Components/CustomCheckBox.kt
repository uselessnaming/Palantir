package com.example.familyproject.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.familyproject.R

@Composable
fun CustomRoundedCheckBox(
    modifier : Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.check),
            contentDescription = "RoundCheckBox",
            tint = Color.Blue,
        )
    }
}