package com.example.familyproject.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.model.data.Todo
import com.example.familyproject.ui.theme.ButtonBackground2
import com.example.familyproject.ui.theme.Gray1
import com.example.familyproject.ui.theme.Gray4
import com.example.familyproject.ui.theme.Gray5
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.dividerColor

@Composable
fun DrawerContent(
    width: Dp,
    value : String,
    onChangeValue : (String) -> Unit,
    onSearchClick : () -> Unit,
) {

    //해당 날짜의 스케줄 리스트
    val itemList = listOf<Todo>(
        Todo(
            title = "아침 스트레칭",
            time = "8:00 AM",
            description = "스트레칭 동영상은 유투브에서 보기",
            isDone = false
        ),
        Todo(
            title = "아침 스트레칭",
            time = "10:00 AM",
            isDone = false
        ),
        Todo(
            title = "아침 스트레칭",
            time = "아침",
            isDone = false
        ),
        Todo(
            title = "점심 스트레칭",
            time = "점심",
            isDone = true
        )
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(width)
            .background(color = Color.White)
            .padding(top = 16.dp, bottom = 26.dp)
    ){
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr){
            SearchBar(
                modifier = Modifier.padding(horizontal = 12.dp),
                value = value,
                onChangeValue = onChangeValue,
                onSearchClick = onSearchClick
            )

            Spacer(Modifier.height(16.dp))

            Divider(thickness = 1.dp, color = dividerColor)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 14.dp)
            ){
                Column(
                    modifier = Modifier
                        .width(76.dp)
                        .height(70.dp)
                        .padding(top = 11.dp, bottom = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    IconButton(
                        modifier = Modifier.size(31.dp),
                        onClick = {
                            /** navigation 이동? */
                        }
                    ){
                        Icon(
                            painter = painterResource(R.drawable.btn_diary),
                            contentDescription = "Diary Button"
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Diary",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.weight(1f))

                Column(
                    modifier = Modifier
                        .width(76.dp)
                        .height(70.dp)
                        .padding(top = 11.dp, bottom = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    IconButton(
                        modifier = Modifier.size(31.dp),
                        onClick = {
                            /** navigation 이동? */
                        }
                    ){
                        Icon(
                            painter = painterResource(R.drawable.btn_routine),
                            contentDescription = "Routine Button"
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Routine",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.weight(1f))

                Column(
                    modifier = Modifier
                        .width(76.dp)
                        .height(70.dp)
                        .padding(top = 11.dp, bottom = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    IconButton(
                        modifier = Modifier.size(31.dp),
                        onClick = {
                            /** navigation 이동? */
                        }
                    ){
                        Icon(
                            painter = painterResource(R.drawable.btn_todo),
                            contentDescription = "Todo Button"
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "To do List",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Gray1)
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "오늘의 스케줄",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = ThickTextColor,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(color = ButtonBackground2)
            ){
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    items(itemList){ item ->
                        ScheduleItem(
                            time = item.time,
                            title = item.title,
                            description = item.description,
                            isDone = item.isDone,
                            onDoneClick = {}
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .shadow(elevation = 6.dp, shape = RoundedCornerShape(size = 10.dp), spotColor = Gray5, ambientColor = Gray5),
                    onClick = {
                        //선택
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Gray4,
                    ),
                    shape = RoundedCornerShape(size = 10.dp),
                    border = BorderStroke(width = 1.dp, color = SpinnerBorder),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp
                    )
                ){
                    Text(
                        text = "할 일 및 루틴 등록하기",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.height(26.dp))
            }
        }
    }
}

@Preview
@Composable
fun TestDrawerContent() {
    val width = LocalConfiguration.current.screenWidthDp
    var value by remember{mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.End
    ){
        DrawerContent(
            width = (width * 0.8).dp,
            value = value,
            onChangeValue = {
                value = it
            },
            onSearchClick = {
            }
        )
    }
}