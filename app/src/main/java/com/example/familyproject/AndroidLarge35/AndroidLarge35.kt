package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.familyproject.AndroidLarge35.CustomBottomSheetDialog
import com.example.familyproject.Components.Calendar.CustomCalendarDialog
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.ui.theme.FamilyProjectTheme

@Composable
fun AndroidLarge35(
    navController : NavController,
    monthCalendar : MonthCalendar
){
    var currentYearMonth by remember{mutableStateOf(monthCalendar.getDate())}
    var selectedDate by remember{ mutableStateOf(monthCalendar.today) }

    var isDateClicked by remember{mutableStateOf(false)}
    var isBottomNavClicked by remember{mutableStateOf(false)}

    if (isDateClicked){
        CustomCalendarDialog(
            monthCalendar = monthCalendar,
            onDismissRequest = {
                isDateClicked = !isDateClicked
            },
            onDateSelected = { date ->
                selectedDate = date
                currentYearMonth = selectedDate.year.toString() + "년" + selectedDate.month.toString() + "월"
                monthCalendar.updateCalendar(date.year, date.month)
                isDateClicked = !isDateClicked
            },
        )
    }

    if (isBottomNavClicked){
        CustomBottomSheetDialog(
            onDismissRequest = {
                isBottomNavClicked = !isBottomNavClicked
            },
            navController = navController,
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
                currentYearMonth = currentYearMonth,
                onMenuClick = {
                    //menu 클릭 이벤트
                },
                onDateClick = {
                    //날짜 클릭 >> DatePicker 생성
                    isDateClicked = !isDateClicked
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            CustomCalendar(
                monthCalendar = monthCalendar,
                selectedDate = selectedDate,
                isBottomNavClick = {
                    isBottomNavClicked = !isBottomNavClicked
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewAndroid(){
    FamilyProjectTheme {
        AndroidLarge35(navController = rememberNavController(), MonthCalendar())
    }
}