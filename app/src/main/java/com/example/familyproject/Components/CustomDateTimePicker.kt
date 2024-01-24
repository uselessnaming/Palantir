package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.familyproject.Components.Menu.CustomTimePicker
import com.example.familyproject.R
import com.example.familyproject.model.data.MonthCalendar
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.Black1
import com.example.familyproject.ui.theme.Black2
import com.example.familyproject.ui.theme.Red1
import java.time.LocalDateTime

@Composable
fun CustomDateTimePicker(
    width : Dp,
    height : Dp,
    onDismiss : () -> Unit,
){

    val calendar = remember{ MonthCalendar() }
    val dayList = calendar.dayList

    var selectedDate by remember{mutableStateOf(calendar.selectedMyDate)}

    var hour by remember{
        var tmpHour = LocalDateTime.now().hour
        if(tmpHour > 12) tmpHour -= 12
        mutableStateOf(
            tmpHour
        )
    }
    var minute by remember{
        var tmpMinute = LocalDateTime.now().minute
        if (tmpMinute % 5 != 0) {
            tmpMinute -= tmpMinute % 5
        }
        mutableStateOf(
            tmpMinute
        )
    }
    var amPm by remember{
        mutableStateOf(
            if (hour >= 12) {
                "오후"
            } else {
                "오전"
            }
        )
    }

    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .height(height)
                .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
                .padding(top = 36.dp, bottom = 21.dp, start = 28.dp, end = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "2022년 11월",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                color = Black1,
                fontWeight = FontWeight(700)
            )

            Spacer(Modifier.height(31.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Mon",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Tue",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Wed",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Thu",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Fri",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Sat",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = AndroidLarge17AmbientColor
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Sun",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = Red1
                )
            }

            Spacer(Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                modifier = Modifier.fillMaxWidth()
            ){
                items(dayList){ date ->
                    if (date.isToday){
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .clickable {
                                    selectedDate = date
                                },
                            text = "${date.day}",
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }

            Spacer(Modifier.height(30.dp))

            CustomTimePicker(
                limitHeight = 140.dp,
                selectedHour = hour,
                selectedMinute = minute,
                selectedAmPm = amPm,
                onHourChanged = {
                    hour = it
                },
                onMinuteChanged = {
                    minute = it
                },
                onAmPmChanged = {
                    amPm = it
                }
            )

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                TextButton(
                    onClick = onDismiss
                ) {
                    Text(
                        text = "취소",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(700),
                        color = AndroidLarge17AmbientColor
                    )
                }

                Spacer(Modifier.width(24.dp))

                TextButton(
                    /** 확인 했을 떄 logic 추가 필요 */
                    onClick = onDismiss
                ){
                    Text(
                        text = "확인",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(700),
                        color = Black2
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestDateTimePikcer(){

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    var isOpen by remember{mutableStateOf(true)}


    if (isOpen){
        CustomDateTimePicker(
            width = (width * 0.8).dp,
            height = (height * 0.7).dp,
            onDismiss = {
                isOpen = false
            }
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                isOpen = true
            }
        ){
            Text(
                text = "click"
            )
        }
    }
}