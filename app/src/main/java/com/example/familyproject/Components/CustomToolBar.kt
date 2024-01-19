package com.example.familyproject.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.familyproject.R

@Composable
fun CustomToolBar(
    content: @Composable () -> Unit,
    onMenuClick : () -> Unit = {},
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        content()
        Spacer(modifier = Modifier.weight(1f))
        CustomImageButton(
            modifier = Modifier.size(30.dp),
            icon = R.drawable.three_dot_menu,
            description = "Open Menu",
            onClick = onMenuClick,
        )
    }
}