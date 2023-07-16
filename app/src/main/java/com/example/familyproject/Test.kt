package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestUnit(
){
    val datePickerState = rememberDatePickerState(
        yearRange = IntRange(2000, 2100),
        initialDisplayMode = DisplayMode.Picker,
        initialSelectedDateMillis = System.currentTimeMillis(),
        initialDisplayedMonthMillis = System.currentTimeMillis(),
    )

    val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
    val monthFormat = SimpleDateFormat("yyyy년 MM월", Locale.getDefault())

    val dateFormatter = remember{
        object : DatePickerFormatter{
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
        modifier = Modifier.padding(vertical = 8.dp)
            .fillMaxSize()
    ){
        DatePickerDialog(
            modifier = Modifier,
            shape = RoundedCornerShape(6.dp),
            onDismissRequest = {

            },
            confirmButton = { Button(onClick = {

                }) {

            }}
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
}

@Composable
@Preview
fun TestUnitPreview(){
    FamilyProjectTheme() {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(color = White)
        ){
            TestUnit()
        }
    }
}