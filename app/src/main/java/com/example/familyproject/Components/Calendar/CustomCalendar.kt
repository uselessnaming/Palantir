package com.example.familyproject

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.ui.theme.CalendarText
import com.example.familyproject.ui.theme.SpinnerBorder
import java.util.Calendar
import java.util.Date

class MonthCalendar{
    private var lastDayOnMonth : Int

    var today : CalendarDay
    private val calendar = Calendar.getInstance()
    private val monthCalendar = Calendar.getInstance()

    init{
        calendar.firstDayOfWeek = Calendar.SUNDAY

        val todayCalendar = Calendar.getInstance()
        val now = Date()
        todayCalendar.time = now
        monthCalendar.time = now

        today = CalendarDay(
            todayCalendar.get(Calendar.YEAR),
            todayCalendar.get(Calendar.MONTH)+1,
            todayCalendar.get(Calendar.DATE),
            true
        )

        lastDayOnMonth = todayCalendar.getMaximum(Calendar.DAY_OF_MONTH)
    }

    fun getDate() : String{
        return "${monthCalendar.get(Calendar.YEAR)}년 ${monthCalendar.get(Calendar.MONTH) + 1}월"
    }

    private val _dayList : MutableLiveData<MutableList<CalendarDay>> = MutableLiveData(getWeekDays())

    val dayList : LiveData<MutableList<CalendarDay>>
        get() = _dayList

    private fun getWeekDays() : MutableList<CalendarDay>{
        val tempDayList = mutableListOf<CalendarDay>()

        /** 기능 테스트 필요 >> 날짜가 일요일에 맞춰서 설정이 되는지*/
        // 임시 대체 val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // 현재 주의 첫 번째 요일 (1부터 7까지의 값)
        val firstDayOfMonth = Calendar.getInstance().apply{
            set(monthCalendar.get(Calendar.YEAR), monthCalendar.get(Calendar.MONTH), 1)
        }

        val firstDayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK)

        // 전 달의 날들로 1일 전을 채움
        val previousMonth = monthCalendar.clone() as Calendar
        previousMonth.add(Calendar.MONTH, -1)
        val lastDayOfPreviousMonth = previousMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        
        for (i in 1 until firstDayOfWeek){
            tempDayList.add(
                CalendarDay(
                    previousMonth.get(Calendar.YEAR),
                    previousMonth.get(Calendar.MONTH),
                    lastDayOfPreviousMonth - (firstDayOfWeek - i -1),
                    false
                )
            )
        }
        
        //이번 달 날들로 채움
        val month = calendar.get(Calendar.MONTH) + 1
        val lastDayOfMonth = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 1..lastDayOfMonth){
            tempDayList.add(
                CalendarDay(
                    monthCalendar.get(Calendar.YEAR),
                    month,
                    i,
                    true
                )
            )
        }

        //다음 달 날들로 7 * 6 사이즈를 맞추기
        val nextMonth = monthCalendar.clone() as Calendar
        nextMonth.add(Calendar.MONTH, 1)
        val daysToAdd = 42 - tempDayList.size
        for (i in 1..daysToAdd){
            CalendarDay(
                nextMonth.get(Calendar.YEAR),
                nextMonth.get(Calendar.MONTH)+1,
                i,
                false
            )
        }

        return tempDayList
    }
}

@Composable
fun CustomCalendar(
    monthCalendar : MonthCalendar
){
    var selectedState by remember{ mutableStateOf(monthCalendar.today) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        val days = monthCalendar.dayList.observeAsState()

        Spacer(modifier = Modifier.height(23.dp))

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

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.padding(top = 16.dp)){
            items(days.value!!){date ->
                Box(
                    modifier = Modifier
                        .width(35.dp)
                        .height(130.dp)
                        .border(
                            border = if(date == selectedState) BorderStroke(width = 1.dp, color = SpinnerBorder) else BorderStroke(width = 0.dp, color = Color.Transparent),
                        )
                        .clickable {
                            selectedState = date
                        }
                ){
                    Column {
                        Text(
                            text = "${date.day}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable{
                                    selectedState = date
                                }
                                .height(35.dp)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            color = if(!date.isNow){SpinnerBorder} else {CalendarText}
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
                .padding(0.dp)
        ){
            CustomImageButton(
                modifier = Modifier,
                icon = R.drawable.add_floating_button,
                description = "Add FLoating Button",
                onClick = {}
            )
        }
    }
}