package com.example.familyproject.Components.Calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.MonthCalendar
import com.example.familyproject.ui.theme.FamilyProjectTheme
import java.util.Calendar

@Composable
fun CustomSubCalendar(){
    val monthCalendar = MonthCalendar()

    val days = monthCalendar.dayList.observeAsState()

    /** AndroidLarge35에서 어떤 날을 선택했을 경우 해당 날짜를 기준으로하는 1중리을 가져오는 것으로 바꿔야 함 (현재 : 현재 월의 첫 주를 가져옴) */

    Column{
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

        val today = Calendar.getInstance()

        val startDate = today.clone() as Calendar
        startDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)

        val endDate = today.clone() as Calendar
        endDate.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
        endDate.add(Calendar.DAY_OF_WEEK, 6)

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            var date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 0)
            var dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 1)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 2)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 3)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 4)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 5)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            date = startDate.clone() as Calendar
            date.add(Calendar.DAY_OF_WEEK, 6)
            dayOfMonth = date.get(Calendar.DAY_OF_MONTH)
            Text(
                modifier = Modifier.weight(1f),
                text = dayOfMonth.toString(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun TestSubCal(){
    FamilyProjectTheme {
        CustomSubCalendar()
    }
}