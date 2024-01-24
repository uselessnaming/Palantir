package com.example.familyproject.Components.Menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.TextColor
import com.example.familyproject.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun CustomTimePicker(
    limitHeight : Dp,
    selectedHour : Int,
    selectedMinute : Int,
    selectedAmPm : String,
    onHourChanged : (Int) -> Unit = {},
    onMinuteChanged : (Int) -> Unit = {},
    onAmPmChanged : (String) -> Unit = {},
) {
    val am_pms = listOf("","오전", "오후","")
    val hours = listOf(0,0,0).plus(1..12).plus(0).plus(0).plus(0)
    val minutes = listOf(0,0,0).plus(0..55 step 5).toList().plus(0).plus(0).plus(0)

    val hourListState = rememberLazyListState(selectedHour)
    val minuteListState = rememberLazyListState(selectedMinute)
    val timeState = rememberLazyListState(am_pms.indexOf(selectedAmPm))

    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(limitHeight)
            .background(color = White)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = timeState
        ) {
            items(am_pms.size) {
                if (am_pms[it] != ""){
                    val isSelected = am_pms[it] == selectedAmPm
                    Text(
                        modifier = Modifier
                            .height(30.dp)
                            .clickable {
                                onAmPmChanged(am_pms[it])
                            }
                            .focusable(isSelected),
                        text = am_pms[it],
                        fontFamily = if (isSelected) FontFamily(Font(R.font.gmarket_sans_ttf_bold)) else FontFamily(
                            Font(R.font.gmarket_sans_ttf_medium)
                        ),
                        color = if (isSelected) Palette1 else TextColor
                    )
                } else {
                    Spacer(Modifier.height(80.dp))
                }
            }
        }

        Spacer(Modifier.width(20.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = hourListState
        ) {
            items(hours.size) {
                val isSelected = hours[it] == selectedHour
                if (hours[it] != 0) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                onHourChanged(hours[it])
                            }
                            .focusable(isSelected),
                        text = "${ hours[it] }",
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
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = minuteListState
        ) {
            items(minutes.size) {
                val isSelected = minutes[it] == selectedMinute
                if (minutes[it] != 0) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                onMinuteChanged(minutes[it])
                            }
                            .focusable(isSelected),
                        text = "${minutes[it]}",
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

        LaunchedEffect(selectedHour, selectedMinute, selectedAmPm) {
            coroutineScope.launch {
                val amPmIndex = am_pms.indexOf(selectedAmPm)
                val hourIndex = hours.indexOf(selectedHour)
                val minuteIndex = minutes.indexOf(selectedMinute)
                hourListState.animateScrollToItem(hourIndex, -150)
                minuteListState.animateScrollToItem(minuteIndex, -150)
                timeState.animateScrollToItem(amPmIndex, -150)
            }
        }
    }
}