package com.example.familyproject.AndroidLarge44

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomEditText
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.DescriptionText
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DiaryScreen(){

    //음력 click 상태 관리
    var isLuna by remember{mutableStateOf(false)}

    //today's feeling 사용 여부
    var useTodayFeeling by remember{mutableStateOf(false)}

    //한줄 요약 사용 여부
    var useSummary by remember{mutableStateOf(false)}

    //오늘의 감정
    var todayFeeling by remember{mutableStateOf("")}

    //한줄 요약
    var summary by remember{mutableStateOf("")}

    //내용
    var content by remember{mutableStateOf("")}

    //날짜 형식
    val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")

    //날짜 정보
    var date by remember{mutableStateOf((LocalDate.now().format(formatter)))}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
    ) {
        Spacer(Modifier.height(18.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .height(48.dp),
        ) {
            CustomImageButton(
                modifier = Modifier.size(24.dp),
                icon = R.drawable.calendar_picker,
                description = "Date Picker",
                onClick = {

                }
            )

            Spacer(Modifier.width(21.dp))

            Column(
                modifier = Modifier.fillMaxHeight()
            ){
                /** 받아온 날짜로 변경 */
                Text(
                    modifier = Modifier.height(24.dp),
                    text = date,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    color = AndroidLarge17SpotColor,
                    lineHeight = 24.sp
                )
                if (isLuna){
                    Text(
                        modifier = Modifier.height(24.dp),
                        text = solarToLuna(date, formatter),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = AndroidLarge17SpotColor,
                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            CustomImageButton(
                modifier = Modifier.padding(0.dp).size(24.dp),
                icon = if (isLuna) R.drawable.done_check else R.drawable.add_picture,
                description = "음력 체크",
                onClick = {
                    isLuna = !isLuna
                }
            )

            Spacer(Modifier.width(11.dp))

            Column(
                modifier = Modifier.height(24.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "음력",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = AndroidLarge17SpotColor
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Today's feeling",
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = DescriptionText
            )

            Spacer(Modifier.width(12.dp))

            CustomImageButton(
                modifier = Modifier
                    .width(55.dp)
                    .height(22.dp),
                icon = if (useTodayFeeling) R.drawable.on_btn else R.drawable.off_btn,
                description = "On and Off Button",
                onClick = {
                    useTodayFeeling = !useTodayFeeling
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        if (useTodayFeeling) {
            CustomEditText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = todayFeeling,
                onValueChange = {
                    todayFeeling = it
                },
                hint = "오늘의 기분을 입력하세요",
                fontSize = 15.sp,
                color = DescriptionText,
            )
        }

        Spacer(Modifier.height(38.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "한줄 요약",
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = DescriptionText
            )

            Spacer(Modifier.width(26.dp))

            CustomImageButton(
                modifier = Modifier
                    .width(55.dp)
                    .height(22.dp),
                icon = if (useSummary) R.drawable.on_btn else R.drawable.off_btn,
                description = "On and Off Button",
                onClick = {
                    useSummary = !useSummary
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        if (useSummary) {
            CustomEditText(
                text = summary,
                onValueChange = {
                    summary = it
                },
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "한줄평을 입력하세요",
                fontSize = 15.sp,
                color = DescriptionText,
            )
        }

        Spacer(Modifier.height(38.dp))

        Text(
            text = "내용",
            fontSize = 15.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            fontWeight = FontWeight(400),
            color = DescriptionText
        )

        Spacer(Modifier.height(10.dp))

        CustomEditText(
            text = content,
            onValueChange = {
                content = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            hint = "내용을 입력하세요",
            fontSize = 15.sp,
            color = DescriptionText
        )
    }
}

/** 음력 변환 방법을 api로 할지 아니면 library 추가할지 찾기 */
private fun solarToLuna(dateString : String, formatter : DateTimeFormatter) : String {
    val lunarCalendar = "2023.03.18"
    return lunarCalendar
}