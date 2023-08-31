package com.example.familyproject.Components.Calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.CalendarDay
import com.example.familyproject.MonthCalendar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.SpinnerBorder

@Composable
fun CustomSubCalendar(
    monthCalendar : MonthCalendar,
    selectedDate : CalendarDay,
    onDateChanged : (CalendarDay) -> Unit
){
    /** AndroidLarge35에서 어떤 날을 선택했을 경우 해당 날짜를 기준으로하는 1중리을 가져오는 것으로 바꿔야 함 (현재 : 현재 월의 첫 주를 가져옴) */
    val daysOfWeek = monthCalendar.weekList.observeAsState()

    val fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium))

    Column{
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "SUN",
                modifier = Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "MON",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "TUE",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "WED",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "THU",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "FRI",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
            Text(
                text = "SAT",
                Modifier
                    .height(21.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = fontFamily
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            daysOfWeek.value!!.forEach{date ->
                Box(
                    modifier = Modifier.weight(1f)
                        .border(
                            border = if(date.day == selectedDate.day) BorderStroke(width = 1.dp, color = SpinnerBorder) else BorderStroke(width = 0.dp, color = Color.Transparent),
                            shape = CircleShape
                        )
                        .clickable{
                            onDateChanged(date)
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = date.day.toString(),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestSubCal(){
    FamilyProjectTheme {
        val monthCalendar = MonthCalendar()
        CustomSubCalendar(
            monthCalendar = monthCalendar,
            selectedDate = monthCalendar.today,
            onDateChanged = {}
        )
    }
}