package com.example.familyproject

data class CalendarDay(
    val year : Int,
    val month : Int,
    val day : Int,
    val day_of_week : Int,
    val isToday : Boolean = true,
)