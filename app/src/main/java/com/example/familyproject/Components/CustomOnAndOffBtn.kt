package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.Border
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.White

@Composable
fun CustomOnAndOffBtn(
    onClick : () -> Unit
){
    Box(
        modifier = Modifier
            .width(57.dp)
            .height(22.dp)
            .border(
                width = 1.dp,
                color = Border,
                shape = RoundedCornerShape(size = 50.dp)
            )
            .background(color = White, shape = RoundedCornerShape(size = 50.dp))
            /** 버튼 Box를 누르면 State를 false로 바꾸고 Image를 off 버튼으로 교환 */
            .clickable{onClick()}
    ){
        CustomButton(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            onClick = {},
            content = "ON",
            contentSize = 12.sp,
            contentPadding = PaddingValues(top = 2.dp, bottom = 2.dp, start = 19.dp, end = 10.dp),
            contentColor = White,
            containerColor = Palette1
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.button_dot),
                contentDescription = "ON & OFF",
                tint = Color(0xFFD9D9D9),
            )
        }
    }
}