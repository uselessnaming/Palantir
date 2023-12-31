package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White

@Composable
fun AddPicturesPicker(
    modifier : Modifier,
    onAddClick : () -> Unit
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(252.dp)
            .background(color = White),
        contentAlignment = Alignment.Center
    ){
        CustomImageButton(
            modifier = Modifier,
            icon = R.drawable.add_floating_button,
            description = "Add Pictures",
            onClick = onAddClick
        )
    }
}

@Preview
@Composable
fun TestAddPicturesPicker(){
    FamilyProjectTheme {
        AddPicturesPicker(
            modifier = Modifier.fillMaxSize(),
            onAddClick = {},
        )
    }
}