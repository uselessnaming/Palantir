package com.example.familyproject.Components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun CustomImageButton(
    modifier : Modifier,
    icon : Int,
    description : String,
    onClick : () -> Unit
){
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ){
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = icon),
            contentDescription = description,
        )
    }
}