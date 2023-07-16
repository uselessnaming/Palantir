package com.example.familyproject.AndroidLarge47

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White

/** 메뉴가 왼족으로 치우쳐져 있는 문제 해결해야 함
 * & 현재 메뉴 기본 공간으로 인해 spacer 혹은 spacedBy 속성 저굥을 못함
 * */

@Composable
fun ThreeDotsMenu(
    width : Dp = 98.dp,
    height : Dp = 96.dp,
    menus : List<String>
){
    LazyColumn(
        modifier = Modifier.height(height)
            .width(width)
            .background(color = White)
            .padding(vertical = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            10.dp
        )
    ){
        items(menus.size){index ->
            DropdownMenuItem(
                onClick = {/* 이동 */},
                text = {Text(
                    text = menus[index],
                    style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = ThickTextColor,)
                )},
            )
        }
    }
}

@Preview
@Composable
fun TestThreeDotsMenu(){
    FamilyProjectTheme {
        ThreeDotsMenu(
            menus = listOf("수정", "복제", "삭제")
        )
    }
}