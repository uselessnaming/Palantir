package com.example.familyproject.Components.Calendar

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.familyproject.CalendarDay
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomTextButton
import com.example.familyproject.Components.Menu.CustomTimePicker
import com.example.familyproject.MonthCalendar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.CalendarText
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White

@Composable
fun CustomCalendarDialog(
    monthCalendar : MonthCalendar,
    selectedNow : CalendarDay,
    onDismissRequest : () -> Unit,
    onDateSelected : (CalendarDay) -> Unit,
){
    var selectedDate by remember{mutableStateOf(selectedNow)}
    var isSpinnerOpen by remember{mutableStateOf(false)}

    Dialog(
        onDismissRequest = {onDismissRequest()},
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(color = White)
                .padding(start = 30.dp, end = 30.dp, top = 27.dp, bottom = 30.dp)
        ){
            val days = monthCalendar.dayList.observeAsState()
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    CustomImageButton(
                        modifier = Modifier.size(30.dp),
                        icon = R.drawable.btn_back,
                        description = "Previous Month",
                        onClick = {
                            selectedDate = if (selectedDate.month == 1){
                                CalendarDay(
                                    selectedDate.year - 1,
                                    12,
                                    1,
                                    false
                                )
                            } else {
                                CalendarDay(
                                    selectedDate.year,
                                    selectedDate.month - 1,
                                    1,
                                    false
                                )
                            }
                            monthCalendar.updateCalendar(selectedDate.year, selectedDate.month)
                        }
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        modifier = Modifier.padding(top = 3.dp),
                        text = monthCalendar.getDate(),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_bold)),
                        color = ThickTextColor
                    )
                    Spacer(Modifier.width(14.dp))

                    CustomImageButton(
                        modifier = Modifier
                            .width(12.dp)
                            .height(9.dp),
                        icon = R.drawable.btn_spinner,
                        description = "Spinner Btn",
                        onClick = {
                            isSpinnerOpen = !isSpinnerOpen
                        }
                    )

                    Spacer(Modifier.weight(1f))

                    CustomImageButton(
                        modifier = Modifier.size(30.dp),
                        icon = R.drawable.btn_next,
                        description = "Next Month",
                        onClick = {
                            selectedDate = if (selectedDate.month == 12){
                                CalendarDay(
                                    selectedDate.year + 1,
                                    1,
                                    1,
                                    false
                                )
                            } else {
                                CalendarDay(
                                    selectedDate.year,
                                    selectedDate.month + 1,
                                    1,
                                    false
                                )
                            }
                            monthCalendar.updateCalendar(selectedDate.year, selectedDate.month)
                        }
                    )
                }

                Spacer(Modifier.height(14.dp))

                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ){
                    Text(text = "SUN",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Text(text = "MON",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                    Text(text = "TUE",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                    Text(text = "WED",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                    Text(text = "THU",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                    Text(text = "FRI",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                    Text(text = "SAT",
                        Modifier
                            .height(21.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp)
                }

                Spacer(Modifier.height(12.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(7)
                ){
                    items(days.value!!){date ->
                        Log.d("BBBBBB","date : ${date}")
                        Box(
                            modifier = Modifier
                                .width(35.dp)
                                .wrapContentHeight()
                                .border(
                                    border = if (date == selectedDate) BorderStroke(
                                        width = 1.dp,
                                        color = SpinnerBorder
                                    ) else BorderStroke(width = 0.dp, color = Color.Transparent),
                                )
                                .clickable {
                                    selectedDate = date
                                }
                        ){
                            Column {
                                Text(
                                    text = "${date.day}",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            selectedDate = date
                                        }
                                        .height(35.dp)
                                        .padding(8.dp),
                                    textAlign = TextAlign.Center,
                                    color = if(!date.isNow){
                                        SpinnerBorder
                                    } else {
                                        CalendarText
                                    },
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium))
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.height(29.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    CustomTextButton(
                        modifier = Modifier.clickable{
                            onDismissRequest()
                        },
                        content = "취소",
                        textColor = ThickTextColor,
                        fontSize = 16.sp,
                    )
                    Spacer(Modifier.width(26.dp))
                    CustomTextButton(
                        modifier = Modifier.clickable{
                            onDateSelected(selectedDate)
                        },
                        content = "확인",
                        textColor = ThickTextColor,
                        fontSize =16.sp,
                    )
                }
                if (isSpinnerOpen){
                    CustomTimePicker(
                        onDismissRequest = {
                            isSpinnerOpen = !isSpinnerOpen
                        },
                        onTimeSelected = { year, month ->
                            selectedDate = CalendarDay(
                                year,
                                month,
                                1,
                                false
                            )
                            isSpinnerOpen = !isSpinnerOpen
                        }
                    )
                }
            }
        }
        LaunchedEffect(selectedDate){
            monthCalendar.updateCalendar(selectedDate.year, selectedDate.month)
        }
    }
}

@Preview
@Composable
fun TestCustomCalendarDialog(){
    FamilyProjectTheme {
        val monthCalendar = MonthCalendar()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = White)
        ){
            CustomCalendarDialog(
                monthCalendar = monthCalendar,
                onDismissRequest = {},
                onDateSelected = {},
                selectedNow = monthCalendar.today
            )
        }
    }
}