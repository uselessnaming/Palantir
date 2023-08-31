package com.example.familyproject

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.ui.theme.CalendarText
import com.example.familyproject.ui.theme.SpinnerBorder
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.Calendar
import java.util.Date

class MonthCalendar{
    private var lastDayOnMonth : Int

    var today : CalendarDay
    private val calendar = Calendar.getInstance()
    private val monthCalendar = Calendar.getInstance()

    private val tmpDayList = mutableListOf<CalendarDay>() //임시로 저장된 한 달의 Date List

    private val tmpWeekList = mutableListOf<CalendarDay>()  //임시로 저장된 한 주의 Date List

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

        getWeekDays()
    }

    //CustomCalendar 사용 시 이용
    private val _dayList : MutableLiveData<MutableList<CalendarDay>> = MutableLiveData(tmpDayList)

    val dayList : LiveData<MutableList<CalendarDay>>
        get() = _dayList

    //AndrodiLarge36과 같이 주간으로 사용시 이용
    private val _weekList : MutableLiveData<MutableList<CalendarDay>> = MutableLiveData(tmpWeekList)

    val weekList : LiveData<MutableList<CalendarDay>>
        get() = _weekList

    private fun submitList(list : MutableList<CalendarDay>, targetList : MutableList<CalendarDay>){
        targetList.clear()
        targetList.addAll(list)
    }

    fun getDate() : String{
        return "${monthCalendar.get(Calendar.YEAR)}년 ${monthCalendar.get(Calendar.MONTH)+1}월"
    }
    
    /**해당 년도와 달을 기점으로 달력을 업데이트 하는 함수 */
    fun updateCalendar(year : Int, month : Int, type : String = "") {

        monthCalendar.set(Calendar.YEAR, year)
        monthCalendar.set(Calendar.MONTH, month-1)
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)

        val tmpList = mutableListOf<CalendarDay>()

        val firstDayOfMonth = Calendar.getInstance().apply{
            set( year, month-1, 1)
        }

        val firstDayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK)

        // 전 달의 날들로 1일 전을 채움
        val previousMonth = monthCalendar.clone() as Calendar
        previousMonth.add(month, -1)
        val lastDayOfPreviousMonth = previousMonth.getActualMaximum(Calendar.DAY_OF_MONTH)

        for (i in 1 until firstDayOfWeek){
            tmpList.add(
                CalendarDay(
                    previousMonth.get(Calendar.YEAR),
                    previousMonth.get(Calendar.MONTH),
                    lastDayOfPreviousMonth - (firstDayOfWeek - i - 1),
                    false
                )
            )
        }

        //이번 달 날들로 채움
        val lastDayOfMonth = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 1..lastDayOfMonth){
            tmpList.add(
                CalendarDay(
                    monthCalendar.get(Calendar.YEAR),
                    month,
                    i,
                    true
                )
            )
        }

        //다음 달 날짜 추가
        val nextMonth = monthCalendar.clone() as Calendar
        nextMonth.add(month, 1)
        var daysToAdd = 0
        //다음 달 몇 일을 추가해야 할 지 설정
        for (i in 0..6){
            if ((tmpList.size + i)%7 == 0){
                daysToAdd = i
                break
            }
        }

        for (i in 1..daysToAdd){
            tmpList.add(
                CalendarDay(
                    nextMonth.get(Calendar.YEAR),
                    nextMonth.get(Calendar.MONTH)+2,
                    i,
                    false
                )
            )
        }
        if (type == "dialog") {
            while(tmpList.size < 42){
                tmpList.add(
                    CalendarDay(
                        year = 0,
                        month = 0,
                        day = 0,
                        isNow = false
                    )
                )
            }
        }else {
            tmpList.removeAll { it == (CalendarDay(0, 0, 0, false)) }
        }
        Log.d("CustomCalendar","days = ${tmpList} \n size = ${tmpList.size}")

        submitList(tmpList, tmpDayList)
    }

    //initialize 할 때 기본 달력
    private fun getWeekDays(){

        val tmpList = mutableListOf<CalendarDay>()

        /** 기능 테스트 필요 >> 날짜가 일요일에 맞춰서 설정이 되는지*/
        val firstDayOfMonth = Calendar.getInstance().apply{
            set(monthCalendar.get(Calendar.YEAR), monthCalendar.get(Calendar.MONTH), 1)
        }

        val firstDayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK)

        // 전 달의 날들로 1일 전을 채움
        val previousMonth = monthCalendar.clone() as Calendar
        previousMonth.add(Calendar.MONTH, -1)
        val lastDayOfPreviousMonth = previousMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        
        for (i in 1 until firstDayOfWeek){
            tmpList.add(
                CalendarDay(
                    previousMonth.get(Calendar.YEAR),
                    previousMonth.get(Calendar.MONTH)+1,
                    lastDayOfPreviousMonth - (firstDayOfWeek - i -1),
                    false
                )
            )
        }
        
        //이번 달 날들로 채움
        val month = today.month
        val lastDayOfMonth = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 1 .. lastDayOfMonth){
            tmpList.add(
                CalendarDay(
                    monthCalendar.get(Calendar.YEAR),
                    month,
                    i,
                    true
                )
            )
        }

        //다음 달 날짜 추가
        val nextMonth = monthCalendar.clone() as Calendar
        nextMonth.add(month, 1)
        var daysToAdd = 0
        //다음 달 몇 일을 추가해야 할 지 설정
        for (i in 0..6){
            if ((tmpList.size + i)%7 == 0){
                daysToAdd = i
                break
            }
        }
        for (i in 1..daysToAdd){
            tmpList.add(
                CalendarDay(
                    nextMonth.get(Calendar.YEAR),
                    nextMonth.get(Calendar.MONTH)+1,
                    i,
                    false
                )
            )
        }
        submitList(tmpList, tmpDayList)
    }

    fun getWeek(selectedDate : CalendarDay){
        val tmpList = mutableListOf<CalendarDay>()

        val targetDate = LocalDate.of(selectedDate.year, selectedDate.month, selectedDate.day)
        val startOfWeek = targetDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
        val endOfWeek = targetDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))

        var tmpDate = startOfWeek
        while(!tmpDate.isAfter(endOfWeek)){
            tmpList.add(
                CalendarDay(
                    tmpDate.year,
                    tmpDate.monthValue,
                    tmpDate.dayOfMonth,
                    false
                )
            )
            tmpDate = tmpDate.plusDays(1)
        }
        submitList(tmpList, tmpWeekList)
    }
}

@Composable
fun CustomCalendar(
    monthCalendar : MonthCalendar,
    selectedDate : CalendarDay,
    onChangeSelectDate : (CalendarDay) -> Unit,
    isBottomNavClick : () -> Unit
){
    val TAG = "CustomCalendar"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        val days = monthCalendar.dayList.observeAsState()
        Log.d(TAG,"days = ${days}")

        Row(
            Modifier
                .fillMaxWidth()
                .height(21.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(text = "SUN",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "MON",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "TUE",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "WED",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "THU",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "FRI",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
            Text(
                text = "SAT",
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f)
        ){
            items(days.value!!){date ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(110.dp)
                        .clickable {
                            onChangeSelectDate(date)
                        }
                ){
                    Column{
                        Text(
                            text = "${date.day}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onChangeSelectDate(date)
                                }
                                .height(35.dp)
                                .padding(8.dp)
                                .border(
                                    border = if (date == selectedDate) BorderStroke(
                                        width = 1.dp,
                                        color = SpinnerBorder
                                    ) else BorderStroke(width = 0.dp, color = Color.Transparent),
                                    shape = CircleShape
                                ),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            color = if(!date.isNow) SpinnerBorder else CalendarText
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 7.dp)
                .height(50.dp)
        ){
            CustomImageButton(
                modifier = Modifier,
                icon = R.drawable.add_floating_button,
                description = "Add FLoating Button",
                onClick = isBottomNavClick
            )
        }
    }
}