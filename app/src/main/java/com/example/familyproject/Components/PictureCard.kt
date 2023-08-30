package com.example.familyproject.Components

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PictureCard(
    modifier : Modifier,
    imageUri : Uri,
){
    val image = rememberImagePainter(imageUri)

    Card(
        modifier = modifier,
    ){
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "Selected Image"
        )
    }
}