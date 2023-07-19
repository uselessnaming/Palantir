package com.example.familyproject.AndroidLarge47

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White

/** 메뉴가 왼족으로 치우쳐져 있는 문제 해결해야 함
 * & 현재 메뉴 기본 공간으로 인해 spacer 혹은 spacedBy 속성 저굥을 못함
 * */

@Composable
fun ThreeDotsMenu(
    navController : NavController,
    width : Dp = 98.dp,
    isExpanded : Boolean,
    menus : List<String>,
    navs : List<String>,
    onDismissRequest : () -> Unit,
){
    DropdownMenu(
        modifier = Modifier.wrapContentHeight().width(width).background(White),
        expanded = isExpanded,
        onDismissRequest = onDismissRequest,
    ) {
        menus.forEach{menu ->
            val i = menus.indexOf(menu)
            Box(
                modifier = Modifier.wrapContentSize(),
                contentAlignment = Alignment.Center
            ){
                DropdownMenuItem(
                    onClick = {/* 이동 */},
                    text = {Text(
                        text = menu,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            color = ThickTextColor,)
                    )}
                )
            }
        }
    }
}

@Preview
@Composable
fun TestThreeDotsMenu(){
    FamilyProjectTheme {
        var isMenuDown by remember{mutableStateOf(true)}
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            ThreeDotsMenu(
                navController = rememberNavController(),
                menus = listOf("수정", "복제", "삭제"),
                navs = listOf(),
                isExpanded = isMenuDown,
                onDismissRequest = {isMenuDown = !isMenuDown},
            )
        }
    }
}