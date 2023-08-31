package com.example.familyproject.Components.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.familyproject.Components.CustomTextButton
import com.example.familyproject.R
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.TextColor
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun CustomTimePicker(
    selectedYear : Int,
    selectedMonth : Int,
    onYearChange : (Int) -> Unit = {},
    onMonthChange : (Int) -> Unit = {},
    onDismissRequest : () -> Unit,
    onTimeSelected : (Int, Int) -> Unit
) {

    val thisYear = LocalDate.now().year
    val thisMonth = LocalDate.now().monthValue

    val years = (1980..thisYear + 20).toList().plus(0).plus(0).plus(0).plus(0)
    val months = (1..12).toList().plus(0).plus(0).plus(0).plus(0).toList()

    val yearListState = rememberLazyListState((thisYear - 1980))
    val monthListState = rememberLazyListState(thisMonth)

    val coroutineScope = rememberCoroutineScope()

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .width(282.dp)
                .height(230.dp)
                .background(color = White)
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                LazyColumn(
                    modifier = Modifier.weight(3f),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = yearListState
                ) {
                    items(years.size) {
                        val isSelected = years[it] == selectedYear
                        if (years[it] != 0) {
                            Text(
                                modifier = Modifier
                                    .clickable {
                                        onYearChange(years[it])
                                    }
                                    .focusable(isSelected),
                                text = years[it].toString() + "년",
                                fontFamily = if (isSelected) FontFamily(Font(R.font.gmarket_sans_ttf_bold)) else FontFamily(
                                    Font(R.font.gmarket_sans_ttf_medium)
                                ),
                                color = if (isSelected) Palette1 else TextColor
                            )
                        } else {
                            Text(
                                text = ""
                            )
                        }
                    }
                }
                LazyColumn(
                    modifier = Modifier.weight(2f),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = monthListState
                ) {
                    items(months.size) {
                        val isSelected = months[it] == selectedMonth
                        if (months[it] != 0) {
                            Text(
                                modifier = Modifier
                                    .clickable {
                                        onMonthChange(months[it])
                                    }
                                    .focusable(isSelected),
                                text = months[it].toString() + "월",
                                fontFamily = if (isSelected) FontFamily(Font(R.font.gmarket_sans_ttf_bold)) else FontFamily(
                                    Font(R.font.gmarket_sans_ttf_medium)
                                ),
                                color = if (isSelected) Palette1 else TextColor
                            )
                        } else {
                            Text(text = "")
                        }
                    }
                }
                LaunchedEffect(selectedYear, selectedMonth) {
                    coroutineScope.launch {
                        val yearIndex = years.indexOf(selectedYear)
                        val monthIndex = months.indexOf(selectedMonth)
                        yearListState.animateScrollToItem(yearIndex, -230)
                        monthListState.animateScrollToItem(monthIndex, -230)
                    }
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.height(16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CustomTextButton(
                    modifier = Modifier.clickable {
                        onDismissRequest()
                    },
                    content = "취소",
                    textColor = ThickTextColor,
                    fontSize = 16.sp,
                )
                Spacer(Modifier.width(26.dp))
                CustomTextButton(
                    modifier = Modifier.clickable {
                        onTimeSelected(selectedYear, selectedMonth)
                    },
                    content = "확인",
                    textColor = ThickTextColor,
                    fontSize = 16.sp,
                )
            }
        }
    }
}