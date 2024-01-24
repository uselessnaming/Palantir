package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.searchBarBackgroundColor
import com.example.familyproject.ui.theme.searchBarBorderColor

@Composable
fun SearchBar(
    modifier : Modifier,
    value : String,
    onChangeValue : (String) -> Unit,
    onSearchClick : () -> Unit,
){
    Row(
        modifier = modifier
            .background(color = searchBarBackgroundColor, shape = RoundedCornerShape(size = 50.dp))
            .border(
                width = 1.dp,
                color = searchBarBorderColor,
                shape = RoundedCornerShape(size = 50.dp)
            )
            .height(48.dp)
            .padding(horizontal = 10.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        BasicTextField(
            modifier = Modifier
                .weight(1f),
            value = value,
            onValueChange = onChangeValue
        )

        Spacer(Modifier.width(10.dp))

        IconButton(
            modifier = Modifier.size(30.dp),
            onClick = onSearchClick
        ) {
            Icon(
                painter = painterResource(R.drawable.btn_search),
                contentDescription = "Search Button"
            )
        }
    }
}