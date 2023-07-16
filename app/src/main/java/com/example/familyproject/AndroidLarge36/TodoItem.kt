package com.example.familyproject.AndroidLarge36

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.R
import com.example.familyproject.model.data.Todo
import com.example.familyproject.ui.theme.Border
import com.example.familyproject.ui.theme.TextColor
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.TodoBackground

@Composable
fun TodoItem(){

    //todoList >> 날짜에 해당하는 Todo를 담은 데이터 리스트
    val todoList = remember{ mutableListOf(
        Todo("8:00 AM", "아침 스트레칭", "스트레칭 동영상은 유튜브에서 보기"),
        Todo("10:00 AM", "아침 스트레칭")) }

    LazyColumn{
        items(todoList.size){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Border, shape = RoundedCornerShape(size = 10.dp))
                    .background(color = TodoBackground, shape = RoundedCornerShape(size = 10.dp))
                    .padding(start = 14.dp, top = 14.dp, bottom = 14.dp)
            ){
                Column{
                    Text(
                        text = todoList[it].time,
                        fontSize = 16.sp,
                        color = ThickTextColor
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = todoList[it].title,
                        fontSize = 16.sp,
                        color = ThickTextColor
                    )

                    if (todoList[it].description != null){
                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = todoList[it].description!!,
                            fontSize = 14.sp,
                            color = TextColor
                        )
                    }
                }
                CustomImageButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    icon = R.drawable.check,
                    description = "Todo Check",
                    onClick = {}
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}