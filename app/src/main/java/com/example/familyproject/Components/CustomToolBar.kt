package com.example.familyproject.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.familyproject.AndroidLarge47.ThreeDotsMenu
import com.example.familyproject.R
import com.example.familyproject.ui.theme.ThickTextColor

@Composable
fun CustomToolBar(
    navController : NavController,
    currentYearMonth : String,
    onMenuClick : () -> Unit = {},
    onDateClick : () -> Unit = {},
    onModeChange : () -> Unit = {},
    mode : Int = 0,
    isExpanded : Boolean,
    menus : List<String>,
    navs : List<String>,
    onDismissRequest : () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        CustomTextButton(
            modifier = Modifier.clickable{
                onDateClick()
            },
            content = currentYearMonth,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            textColor = ThickTextColor
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomImageButton(
            modifier = Modifier.size(30.dp),
            icon = if (mode == 0) R.drawable.three_dot_menu else if (mode == 1) R.drawable.calendar_picker else throw NoSuchElementException("해당 요소는 존재하지 않습니다."),
            description = "Weekly Mode",
            onClick = onModeChange,
        )
        Spacer(modifier = Modifier.width(18.dp))
        Row(
            modifier = Modifier.height(30.dp).width(30.dp)
        ){
            CustomImageButton(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                icon = R.drawable.menu,
                description = "menu",
                onClick = onMenuClick
            )
            ThreeDotsMenu(
                navController = navController,
                isExpanded = isExpanded,
                menus = menus,
                navs = navs,
                onDismissRequest = onDismissRequest
            )
        }
    }
}