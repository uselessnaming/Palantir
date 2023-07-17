package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.Components.Calendar.CustomCalendarDialog
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.ui.theme.FamilyProjectTheme

@Composable
fun AndroidLarge35(
    navController : NavController
){
    val monthCalendar = MonthCalendar()

    val currentYearMonth = remember{mutableStateOf(monthCalendar.getDate())}
    var selectedDate by remember{ mutableStateOf(monthCalendar.today) }

    var isDateClicked by remember{mutableStateOf(false)}

    if (isDateClicked){
        CustomCalendarDialog(
            onDismissRequest = {
                isDateClicked = !isDateClicked
            },
            onDateSelected = { date ->
                selectedDate = date
                isDateClicked = !isDateClicked
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ){
        /** R.drawable.calendar_picker하고 three_dots_menu하고 switch */
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ){

            CustomToolBar(
                currentYearMonth = currentYearMonth.value,
                onMenuClick = {
                    //menu 클릭 이벤트
                },
                onDateClick = {
                    //날짜 클릭 >> DatePicker 생성
                    isDateClicked = !isDateClicked
                }
            )
            CustomCalendar(monthCalendar = getSelectedMonthCalendar(selectedDate))
        }
    }
}

fun getSelectedMonthCalendar(selectedDate : CalendarDay) : MonthCalendar{
    val monthCalendar = MonthCalendar()

    val year = selectedDate.year
    val month = selectedDate.month
    val day = selectedDate.day

    monthCalendar.updateCalendar(year, month, day)

    return monthCalendar
}

@Preview
@Composable
fun PreviewAndroid(){
    FamilyProjectTheme {
        AndroidLarge35(navController = rememberNavController())
    }
}