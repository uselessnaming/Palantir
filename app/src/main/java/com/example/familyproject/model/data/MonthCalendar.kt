package com.example.familyproject.model.data

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.familyproject.CalendarDay
import java.util.Calendar

const val TTAG = "TestTAG"
class MonthCalendar {

    val TAG = "MonthCalendar"

    val calendar : Calendar by lazy {
        Calendar.getInstance()
    }

    val today : CalendarDay
    var selectedMyDate : CalendarDay

    var dayList : SnapshotStateList<CalendarDay>

    //초기화 시 오늘 날짜로
    init{
        //오늘의 날짜 미리 가져오기
        today = CalendarDay(
            calendar.get(Calendar.YEAR), //년도
            calendar.get(Calendar.MONTH) + 1, //월
            calendar.get(Calendar.DAY_OF_MONTH), //일
            calendar.get(Calendar.DAY_OF_WEEK) //요일
        )

        //현재 선택된 날짜
        selectedMyDate = today

        dayList = mutableStateListOf<CalendarDay>()


        val tmpCalendar = Calendar.getInstance()

        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)
        var firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)

        //이번 달 달력 중 과거 부분
        tmpCalendar.add(Calendar.MONTH, -1)
        val maxDate = tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        tmpCalendar.add(Calendar.DAY_OF_MONTH, (maxDate-firstDayOfWeek))

        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..maxDate){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(i - firstDayOfWeek - 1)%7,false))
        }

        //이번 달 달력 중 현재 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        for (i:Int in tmpCalendar.getActualMinimum(Calendar.DAY_OF_MONTH)..tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(firstDayOfWeek + i - 1)%7))
        }

        //이번 달 달력 중 미래 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..(7 - (dayList.size%7))){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month=tmpCalendar.get(Calendar.MONTH)+1, day=i, day_of_week=(firstDayOfWeek+i)%7, false))
        }
    }

    //날짜를 계산하는 함수
    private fun calDate(date : CalendarDay, diff : Int) : CalendarDay{
        val tmpCalendar = Calendar.getInstance()
        tmpCalendar.set(date.year, date.month-1, date.day)
        tmpCalendar.add(Calendar.DAY_OF_WEEK, diff)

        return CalendarDay(
            year = tmpCalendar.get(Calendar.YEAR),
            month = tmpCalendar.get(Calendar.MONTH)+1,
            day = tmpCalendar.get(Calendar.DAY_OF_MONTH),
            day_of_week = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        )
    }

    //날짜 변경
    fun setDate(myDate : CalendarDay){
        selectedMyDate = myDate
    }

    //날짜 받아오기
    fun getDate() = "${selectedMyDate.month}월"

    //선택된 날을 기반으로 1주일 가져오기
    fun getWeek() {
        val resultList = listOf<CalendarDay>()


    }

    fun setNextMonth(){

        Log.d(TAG, "--------------------------------------------")

        Log.d(TAG, "onNextMonth Start")
        //dayList를 초기화
        dayList.clear()

        //다음 달로 이동하면 현재 날짜 + 한 달
        calendar.set(selectedMyDate.year, selectedMyDate.month-1, selectedMyDate.day)
        calendar.add(Calendar.MONTH, 1)

        val newDate = CalendarDay(
            year = calendar.get(Calendar.YEAR),
            month = calendar.get(Calendar.MONTH)+1,
            day = calendar.get(Calendar.DAY_OF_MONTH),
            day_of_week = calendar.get(Calendar.DAY_OF_WEEK)
        )

        selectedMyDate = newDate

        val tmpCalendar = Calendar.getInstance()
        tmpCalendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1)
        var firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)

        //이번 달 달력 중 과거 부분
        tmpCalendar.add(Calendar.MONTH, -1)
        val maxDate = tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        tmpCalendar.add(Calendar.DAY_OF_MONTH, (maxDate-firstDayOfWeek))

        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..maxDate){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(i - firstDayOfWeek - 1)%7, isToday = false))
        }

        //이번 달 달력 중 현재 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        for (i:Int in tmpCalendar.getActualMinimum(Calendar.DAY_OF_MONTH)..tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(firstDayOfWeek + i - 1)%7))
        }

        //이번 달 달력 중 미래 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..(7 - (dayList.size%7))){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month=tmpCalendar.get(Calendar.MONTH)+1, day=i, day_of_week=(firstDayOfWeek+i)%7, isToday = false))
        }

        Log.d(TAG, "nextMonth Done")
    }

    //전달로 이동
    fun setPrevMonth(){
        //dayList를 초기화
        dayList.clear()

        //전 달로 이동하면 현재 날짜 + 일주일
        val tmpCalendar = Calendar.getInstance()
        tmpCalendar.set(selectedMyDate.year, selectedMyDate.month-1, selectedMyDate.day)
        tmpCalendar.add(Calendar.MONTH, -1)

        val newDate = CalendarDay(
            year = tmpCalendar.get(Calendar.YEAR),
            month = tmpCalendar.get(Calendar.MONTH)+1,
            day = tmpCalendar.get(Calendar.DAY_OF_MONTH),
            day_of_week = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        )

        selectedMyDate = newDate

        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)
        var firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)

        //이번 달 달력 중 과거 부분
        tmpCalendar.add(Calendar.MONTH, -1)
        val maxDate = tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        tmpCalendar.add(Calendar.DAY_OF_MONTH, (maxDate-firstDayOfWeek))

        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..maxDate){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(i - firstDayOfWeek - 1)%7, isToday = false))
        }

        //이번 달 달력 중 현재 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        for (i:Int in tmpCalendar.getActualMinimum(Calendar.DAY_OF_MONTH)..tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(firstDayOfWeek + i - 1)%7))
        }

        //이번 달 달력 중 미래 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..(7 - (dayList.size%7))){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month=tmpCalendar.get(Calendar.MONTH)+1, day=i, day_of_week=(firstDayOfWeek+i)%7, isToday = false))
        }
    }


//    //다움 주로 이동
//    fun setNextWeek(){
//
//        //dayList를 초기화
//        dayList.clear()
//
//        //다음 주로 이동하면 현재 날짜 + 일주일
//        val tmpCalendar = Calendar.getInstance()
//        tmpCalendar.set(selectedMyDate.year, selectedMyDate.month-1, selectedMyDate.day)
//        tmpCalendar.add(Calendar.DAY_OF_WEEK, 7)
//
//        val newDate = CalendarDay(
//            year = tmpCalendar.get(Calendar.YEAR),
//            month = tmpCalendar.get(Calendar.MONTH)+1,
//            day = tmpCalendar.get(Calendar.DAY_OF_MONTH),
//            day_of_week = tmpCalendar.get(Calendar.DAY_OF_WEEK)
//        )
//
//        selectedMyDate = newDate
//
//        for (i:Int in 1..7) {
//            val diff = i // - day_of_week
//            dayList.add(calDate(selectedMyDate, diff))
//        }
//    }
//
//    //이전 주로 이동
//    fun setPrevWeek(){
//        //dayList를 초기화
//        dayList.clear()
//
//        //이전 주로 이동하면 현재 날짜 - 일주일
//        val tmpCalendar = Calendar.getInstance()
//        tmpCalendar.set(selectedMyDate.year, selectedMyDate.month-1, selectedMyDate.day)
//        tmpCalendar.add(Calendar.DAY_OF_WEEK, -7)
//
//        val newDate = CalendarDay(
//            year = tmpCalendar.get(Calendar.YEAR),
//            month = tmpCalendar.get(Calendar.MONTH)+1,
//            day = tmpCalendar.get(Calendar.DAY_OF_MONTH),
//            day_of_week = tmpCalendar.get(Calendar.DAY_OF_WEEK)
//        )
//
//        selectedMyDate = newDate
//
//        for (i:Int in 1..7) {
//            val diff = i //- day_of_week
//            dayList.add(calDate(newDate, diff))
//        }
//    }
//
    fun updateCalendar(day : CalendarDay) {

    //dayList를 초기화
        dayList.clear()

        //전 달로 이동하면 현재 날짜 + 일주일
        val tmpCalendar = Calendar.getInstance()
        tmpCalendar.set(day.year, day.month-1, day.day)

        selectedMyDate = day

        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)
        var firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)

        //이번 달 달력 중 과거 부분
        tmpCalendar.add(Calendar.MONTH, -1)
        val maxDate = tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        tmpCalendar.add(Calendar.DAY_OF_MONTH, (maxDate-firstDayOfWeek))

        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..maxDate){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(i - firstDayOfWeek - 1)%7, isToday = false))
        }

        //이번 달 달력 중 현재 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        for (i:Int in tmpCalendar.getActualMinimum(Calendar.DAY_OF_MONTH)..tmpCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month = tmpCalendar.get(Calendar.MONTH)+1, day = i, day_of_week=(firstDayOfWeek + i - 1)%7))
        }

        //이번 달 달력 중 미래 부분
        tmpCalendar.add(Calendar.MONTH, 1)
        tmpCalendar.set(Calendar.DAY_OF_MONTH, 1)

        firstDayOfWeek = tmpCalendar.get(Calendar.DAY_OF_WEEK)
        for (i in tmpCalendar.get(Calendar.DAY_OF_MONTH)..(7 - (dayList.size%7))){
            dayList.add(CalendarDay(year = tmpCalendar.get(Calendar.YEAR), month=tmpCalendar.get(Calendar.MONTH)+1, day=i, day_of_week=(firstDayOfWeek+i)%7, isToday = false))
        }
    }
}
