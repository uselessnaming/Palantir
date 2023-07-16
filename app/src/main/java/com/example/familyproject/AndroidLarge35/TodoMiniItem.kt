package com.example.familyproject.AndroidLarge35

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.TextColor
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.TodoMiniItemBorder
import com.example.familyproject.ui.theme.White

@Composable
fun TodoMiniItem(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(18.dp),
    ){
        Row(
            modifier = Modifier.fillMaxHeight()
                .border(width = 1.dp, color = TodoMiniItemBorder, shape = RoundedCornerShape(size = 3.dp))
                .background(color = White, shape = RoundedCornerShape(size = 3.dp)),
        ){
            Box(
                modifier = Modifier.width(4.dp)
                    .border(width = 1.dp, color = TodoMiniItemBorder, shape = RoundedCornerShape(size = 3.dp))
                    .background(color = TodoMiniItemBorder, shape = RoundedCornerShape(size = 3.dp)),
            ){
                Spacer(Modifier.fillMaxSize())
            }
            Text(
                modifier = Modifier.fillMaxHeight()
                    .weight(1f)
                    .padding(horizontal = 2.dp, vertical = 3.dp),
                /** Text에는 해당 날짜로 저장되어 있는 투두 리스트의 타이들을 받아와야 함 */
                text = "아침에는 스트레칭",
                fontSize = 10.sp,
                color = ThickTextColor,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun TestTodoMiniItem(){
    FamilyProjectTheme{
        Surface(
            Modifier.background(Color.White)
                .width(51.dp)
        ){
            TodoMiniItem()
        }
    }
}