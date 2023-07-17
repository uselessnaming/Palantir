package com.example.familyproject.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.familyproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier : Modifier,
    title : String,
    backIcon : Int,
    description : String,
){
    Column{
        TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 40.dp)
                )
            },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = backIcon),
                    contentDescription = description
                )
            },
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp
        )
    }
}