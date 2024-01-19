package com.example.familyproject.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.familyproject.CalendarDay
import com.example.familyproject.R
import com.example.familyproject.model.data.MonthCalendar
import com.example.familyproject.ui.theme.CalendarText
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.TextColor
import com.example.familyproject.ui.theme.ThickTextColor

@Composable
fun CustomDatePickerDialog(
    width : Dp,
    height : Dp,
    initDate : CalendarDay,
    onChangeDate : (CalendarDay) -> Unit,
    onDismiss : () -> Unit
){
    val TAG = "DatePicker"

    val calendar = remember{ MonthCalendar() }
    val dayList = remember{calendar.dayList}

    var selectedDate by remember{mutableStateOf(initDate)}

    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .height(height)
                .defaultMinSize(minHeight = 500.dp)
                .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
                .padding(top = 27.dp, bottom = 36.dp, start = 20.dp, end = 20.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = {
                        calendar.setPrevMonth()
                        selectedDate = calendar.selectedMyDate
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.btn_back),
                        contentDescription = "Prev Month"
                    )
                }

                Spacer(Modifier.weight(1f))

                Text(
                    text = "${selectedDate.year}년 ${selectedDate.month}월",
                    fontWeight = FontWeight(500),
                    fontSize = 18.sp,
                    color = ThickTextColor
                )

                Spacer(Modifier.weight(1f))

                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = {
                        calendar.setNextMonth()
                        selectedDate = calendar.selectedMyDate
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.btn_next),
                        contentDescription = "Next Month"
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ){
                Text(text = "SUN",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "MON",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "TUE",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "WED",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "THU",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "FRI",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
                Text(
                    text = "SAT",
                    Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                )
            }

            Spacer(Modifier.height(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(dayList){date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                if (date.year < selectedDate.year || date.month < selectedDate.month) {
                                    calendar.setPrevMonth()
                                } else if (date.year > selectedDate.year || date.month > selectedDate.month) {
                                    calendar.setNextMonth()
                                }
                                selectedDate = date
                            }
                            .aspectRatio(1f)
                    ){
                        Column{
                            Text(
                                text = "${date.day}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        if (date.year < selectedDate.year || date.month < selectedDate.month) {
                                            calendar.setPrevMonth()
                                        } else if (date.year > selectedDate.year || date.month > selectedDate.month) {
                                            calendar.setNextMonth()
                                        }
                                        selectedDate = date
                                    }
                                    .height(35.dp)
                                    .padding(8.dp)
                                    .border(
                                        border = if (date == selectedDate) BorderStroke(
                                            width = 1.dp,
                                            color = SpinnerBorder
                                        ) else BorderStroke(
                                            width = 0.dp,
                                            color = Color.Transparent
                                        ),
                                        shape = CircleShape
                                    ),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                color = if(date == selectedDate || date.isToday) CalendarText else TextColor,
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.clickable{
                        onDismiss()
                    }
                ){
                    Text(
                        text = "취소",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                    )
                }

                Spacer(Modifier.width(25.dp))

                Box(
                    modifier = Modifier.clickable{
                        onChangeDate(selectedDate)
                        onDismiss()
                    }
                ){
                    Text(
                        text = "확인",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = ThickTextColor,
                    )
                }
            }
        }
    }
}