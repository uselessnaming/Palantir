package com.example.familyproject.AndroidLarge36

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.CalendarDay
import com.example.familyproject.Components.Calendar.CustomSubCalendar
import com.example.familyproject.Components.CustomButton
import com.example.familyproject.Components.CustomLine
import com.example.familyproject.Components.CustomOutlineButton
import com.example.familyproject.model.data.MonthCalendar
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.Border
import com.example.familyproject.ui.theme.ButtonBackground
import com.example.familyproject.ui.theme.ButtonContent
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.TextColor

@Composable
fun AndroidLarge36(
    monthCalendar : MonthCalendar,
    selectedDate : CalendarDay,
    onDateChanged : (CalendarDay) -> Unit,
){
    var showMode by remember{mutableStateOf("all")}

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        CustomSubCalendar(
            monthCalendar = monthCalendar,
            selectedDate = selectedDate,
            onDateChanged = onDateChanged
        )
        Spacer(modifier = Modifier.height(5.dp))
        CustomLine(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 4.dp,
                    spotColor = AndroidLarge17SpotColor,
                    ambientColor = AndroidLarge17AmbientColor
                ),
            type = "fully row",
            strokeWidth = 2f
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            horizontalArrangement = Arrangement.End
        ){
            Spacer(modifier = Modifier.weight(1f))

            CustomButton(
                modifier = Modifier
                    .width(84.dp)
                    .height(30.dp)
                    .border(
                        width = 1.dp,
                        color = Border,
                        shape = RoundedCornerShape(size = 50.dp)
                    ),
                containerColor = ButtonBackground,
                contentColor = ButtonContent,
                contentSize = 14.sp,
                content = "전체 보기",
                contentPadding = PaddingValues(horizontal = 13.dp, vertical = 6.dp),
                onClick = {
                    showMode = "All"
                },
            )

            Spacer(modifier = Modifier.width(14.dp))

            CustomOutlineButton(
                modifier = Modifier
                    .width(110.dp)
                    .height(30.dp),
                content = "미완료만 보기",
                contentSize = 14.sp,
                contentColor = TextColor,
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                onClick = {
                    showMode = "isNotDone"
                },
            )
        }
        Spacer(modifier = Modifier.height(11.dp))

        /** 해당 날짜에 맞는 Item들을 RecyclerView를 이용해 배치 */
        TodoItem(showMode)
    }
}

@Preview
@Composable
fun TestAndroidLarge36(){
    FamilyProjectTheme {
        val monthCalendar = MonthCalendar()
        AndroidLarge36(
            monthCalendar = monthCalendar,
            selectedDate = monthCalendar.today,
            onDateChanged = {}
        )
    }
}