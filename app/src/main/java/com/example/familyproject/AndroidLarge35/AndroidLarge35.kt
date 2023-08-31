package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.AndroidLarge35.CustomBottomSheetDialog
import com.example.familyproject.AndroidLarge36.AndroidLarge36
import com.example.familyproject.Components.Calendar.CustomCalendarDialog
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.Components.ProjectScreen
import com.example.familyproject.ui.theme.FamilyProjectTheme

@Composable
fun AndroidLarge35(
    navController : NavController,
    monthCalendar : MonthCalendar
){
    //화면 변수
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    var currentYearMonth by remember{mutableStateOf(monthCalendar.getDate())}
    var selectedDate by remember{ mutableStateOf(monthCalendar.today) }

    var isDateClicked by remember{mutableStateOf(false)}
    var isBottomNavClicked by remember{mutableStateOf(false)}
    var isMenuDown by remember{mutableStateOf(false)}
    var showMode by remember{mutableStateOf(0)} //0이면 Monthly 1이면 Weekly

    if (isDateClicked){
        CustomCalendarDialog(
            modifier = Modifier.width((screenWidth * 0.95).dp)
                .height((screenHeight * 0.55).dp),
            monthCalendar = monthCalendar,
            selectedNow = selectedDate,
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
                onModeChange = {
                    showMode = if (showMode == 0) 1 else 0
                },
                mode = showMode,
                onMenuClick = {
                    //menu 클릭 이벤트
                    isMenuDown = !isMenuDown
                },
                onDateClick = {
                    //날짜 클릭 >> DatePicker 생성
                    isDateClicked = !isDateClicked
                },
                isExpanded = isMenuDown,
                menus = listOf("달력","to do list","다이어리"),
                onDismissRequest = {
                    isMenuDown = !isMenuDown
                },
                navController = navController,
                navs = listOf(
                    ProjectScreen.AndroidLarge35.name,
                    ProjectScreen.AndroidLarge35.name,
                    ProjectScreen.AndroidLarge35.name,
                )
            )
            Spacer(modifier = Modifier.height(23.dp))

            //mode가 0이면 달력을 그리고 1이면 주간 리스트를 그림
            if (showMode == 0) {
                CustomCalendar(
                    monthCalendar = monthCalendar,
                    selectedDate = selectedDate,
                    onChangeSelectDate = { date ->
                        selectedDate = date
                    },
                    isBottomNavClick = {
                        isBottomNavClicked = !isBottomNavClicked
                    }
                )
            } else if (showMode == 1){
                //서버에서 해당 날짜에 맞는 데이터를 받아옴
                monthCalendar.getWeek(selectedDate)
                AndroidLarge36(
                    monthCalendar = monthCalendar,
                    selectedDate = selectedDate,
                    onDateChanged = {date ->
                        selectedDate = date
                    }
                )
            } else {
                throw NoSuchElementException("Error : 모드 선택 오류 \n 현재 모드 : ${showMode}.")
            }
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