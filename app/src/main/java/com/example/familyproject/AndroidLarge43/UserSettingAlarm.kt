package com.example.familyproject.AndroidLarge43

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White

@Composable
fun UserSettingAlarm(){

    val minutes = listOf(
        "60","55","50","45","40","35","30","25","20","15","10","5"
    )
    val hours = listOf(
        "1","2","3","4","5","6","7","8","9","10","11","12","13","14",
        "15","16","17","18","19","20","21","22","23","24"
    )
    val days = listOf(
        "1","2","3","4","5","6","7","8","9","10","11","12","13","14",
        "15","16","17","18","19","20","21","22","23","24","25","26",
        "27","28","29","30"
    )
    val weeks = listOf(
        "1","2","3","4","5","6","7","8"
    )
    val types = listOf(
        "분 전", "시간 전", "일 전", "주 전"
    )
    val test = listOf("일정 시작 시간")

    var selectedMinutes by remember{mutableStateOf(minutes[0])}
    var selectedTypes by remember{mutableStateOf(types[0])}
    var selectedTest by remember{mutableStateOf(test[0])}

    Column(
        Modifier.fillMaxWidth()
            .padding(start = 43.dp)
    ){
        /** 뒤쪽 spinner의 값에 따라 앞의 시간을 변경 
            분 전 >> 0~60,
            시간 전 >> 1~24,
            일 전 >> 1~30,
            주 전 >> 1~8 등등
         */
        Row(
            modifier = Modifier.height(30.dp)
                .fillMaxWidth()
        ){
            CustomSpinner(
                items = minutes,
                modifier = Modifier.weight(0.5f),
                onValueChange = {
                    selectedMinutes = it
                }
            )

            Spacer(modifier = Modifier.width(6.dp))

            CustomSpinner(
                items = types,
                modifier = Modifier.weight(0.5f),
                onValueChange = {
                    selectedTypes = it
                }
            )
        }

        Spacer(Modifier.height(16.dp))

        CustomSpinner(
            items = test,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                selectedTypes = it
            }
        )
    }
}

@Preview
@Composable
fun TestUserSettingAlarm(){
    FamilyProjectTheme {
        Column(
            Modifier.background(color = White)
                .fillMaxSize()
        ){
            UserSettingAlarm()
        }
    }
}
