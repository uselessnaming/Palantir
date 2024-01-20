package com.example.familyproject

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.model.data.MonthCalendar
import com.example.familyproject.model.data.TTAG
import com.example.familyproject.ui.theme.CalendarText
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.TextColor

@Composable
fun CustomCalendar(
    monthCalendar : MonthCalendar,
    selectedDate : CalendarDay,
    onChangeSelectDate : (CalendarDay) -> Unit,
    isBottomNavClick : () -> Unit
){
    val TAG = "CustomCalendar"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        val days = monthCalendar.dayList

        Row(
            Modifier
                .fillMaxWidth()
                .height(21.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(text = "SUN",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "MON",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "TUE",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "WED",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "THU",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "FRI",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "SAT",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f)
        ){
            items(days){date ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(110.dp)
                        .clickable {
                            if (date.year < selectedDate.year || (date.year == selectedDate.year && date.month < selectedDate.month)) {
                                monthCalendar.setPrevMonth()
                            } else if (date.year > selectedDate.year || date.month > selectedDate.month) {
                                monthCalendar.setNextMonth()
                            }
                            onChangeSelectDate(date)
                        }
                ){
                    Column{
                        Text(
                            text = "${date.day}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (date.year < selectedDate.year || (date.year == selectedDate.year && date.month < selectedDate.month)) {
                                        monthCalendar.setPrevMonth()
                                    } else if (date.year > selectedDate.year || date.month > selectedDate.month) {
                                        monthCalendar.setNextMonth()
                                    }
                                    onChangeSelectDate(date)
                                    return@clickable
                                }
                                .height(35.dp)
                                .padding(8.dp)
                                .border(
                                    border = if (date == selectedDate) BorderStroke(
                                        width = 1.dp,
                                        color = SpinnerBorder
                                    ) else BorderStroke(width = 0.dp, color = Color.Transparent),
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
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 7.dp)
                .height(50.dp)
        ){
            CustomImageButton(
                modifier = Modifier,
                icon = R.drawable.add_floating_button,
                description = "Add FLoating Button",
                onClick = isBottomNavClick
            )
        }
    }
}