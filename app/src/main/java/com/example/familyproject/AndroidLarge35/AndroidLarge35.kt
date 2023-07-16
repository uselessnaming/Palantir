package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
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
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidLarge35(
    navController : NavController
){
    val monthCalendar = MonthCalendar()

    val currentYearMonth = remember{mutableStateOf(monthCalendar.getDate())}
    var selectedDate by remember{ mutableStateOf(monthCalendar.today) }

    var isDateClicked by remember{mutableStateOf(false)}

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis(),
        initialDisplayedMonthMillis = System.currentTimeMillis(),
        yearRange = 1900..2100,
    )
    val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
    val monthFormat = SimpleDateFormat("yyyy년 MM월", Locale.getDefault())

    val dateFormatter = remember{
        object : DatePickerFormatter {
            override fun formatDate(
                dateMillis: Long?,
                locale: Locale,
                forContentDescription: Boolean,
            ): String? {
                return dateFormat.format(dateMillis)
            }

            override fun formatMonthYear(monthMillis: Long?, locale: Locale): String? {
                return monthFormat.format(monthMillis)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ){
        if (isDateClicked){
            DatePickerDialog(
                modifier = Modifier,
                shape = RoundedCornerShape(6.dp),
                onDismissRequest = {

                },
                confirmButton = {
                    Button(onClick = {
                    }) {
                    }
                }
            ){
                DatePicker(
                    modifier = Modifier.weight(1f),
                    state = datePickerState,
                    dateFormatter = dateFormatter,
                    title = null,
                    headline = null,
                    showModeToggle = false,
                    colors = DatePickerDefaults.colors(White)
                )
            }
        }

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

            CustomCalendar(monthCalendar = monthCalendar)
        }
    }
}

@Preview
@Composable
fun PreviewAndroid(){
    FamilyProjectTheme {
        AndroidLarge35(navController = rememberNavController())
    }
}