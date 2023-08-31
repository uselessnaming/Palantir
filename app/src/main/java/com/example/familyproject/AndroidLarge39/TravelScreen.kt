package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.familyproject.Components.CustomButton
import com.example.familyproject.Components.CustomEditText
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.ButtonBackgroundPurple
import com.example.familyproject.ui.theme.DescriptionText
import com.example.familyproject.ui.theme.White
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TravelScreen(){
    //음력 click 상태 관리
    var isLuna by remember{mutableStateOf(false)}

    //시간 표시 상태 관리
    var isShowTime by remember{mutableStateOf(false)}

    //여행지 사용 여부
    var useDestination by remember{mutableStateOf(false)}

    //동행인 사용 여부
    var useCompanion by remember{mutableStateOf(false)}

    //여행 일정 사용 여부
    var useScheduler by remember{mutableStateOf(false)}

    //여행지
    var destination by remember{mutableStateOf("")}

    //동행인
    var companion by remember{mutableStateOf("")}

    //여행 일정
    var scheduler by remember{mutableStateOf("")}

    //내용
    var content by remember{mutableStateOf("")}

    //날짜 설정 변수
    val today = LocalDateTime.now()

    //날짜 형식
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")
    val hourFormatter = DateTimeFormatter.ofPattern("a hh시 mm분")

    //날짜 정보
    var startDate by remember{mutableStateOf((today.format(dateFormatter)))}
    var startTime by remember{mutableStateOf(today.format(hourFormatter))}
    var endDate by remember{mutableStateOf(today.format(dateFormatter))}
    var endTime by remember{mutableStateOf(today.plusHours(1).format(hourFormatter))}

    /** 작성된 정보를 기반으로 데이터를 추가 */
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp)
    ) {
        Spacer(Modifier.height(18.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .height(24.dp),
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
                    text = startDate,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    color = AndroidLarge17SpotColor,
                    lineHeight = 24.sp
                )
            }

            Spacer(Modifier.weight(1f))

            /** 선택시 시간 선택할 수 있는 dialog */
            if (isShowTime){
                Text(
                    modifier = Modifier.height(24.dp),
                    text = startTime,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    color = AndroidLarge17SpotColor,
                    lineHeight = 24.sp
                )
            }
        }
        if (isLuna){
            Text(
                modifier = Modifier.height(24.dp)
                    .padding(start = 45.dp),
                text = solarToLuna(
                    startDate,
                    dateFormatter
                ),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                color = AndroidLarge17SpotColor,
                lineHeight = 24.sp
            )
        }

        Spacer(Modifier.height(22.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .height(24.dp),
        ) {
            Spacer(Modifier.width(45.dp))

            Column(
                modifier = Modifier.fillMaxHeight()
            ){
                /** 받아온 날짜로 변경 */
                Text(
                    modifier = Modifier.height(24.dp),
                    text = endDate,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    color = AndroidLarge17SpotColor,
                    lineHeight = 24.sp
                )
            }

            Spacer(Modifier.weight(1f))

            /** 선택시 시간 선택할 수 있는 dialog */
            if (isShowTime){
                Text(
                    modifier = Modifier.height(24.dp),
                    text = endTime,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    color = AndroidLarge17SpotColor,
                    lineHeight = 24.sp
                )
            }
        }
        if (isLuna){
            Text(
                modifier = Modifier.height(24.dp)
                    .padding(start = 45.dp),
                text = solarToLuna(
                    endDate,
                    dateFormatter
                ),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                color = AndroidLarge17SpotColor,
                lineHeight = 24.sp
            )
        }

        Spacer(Modifier.height(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(Modifier.width(63.dp))

            CustomImageButton(
                modifier = Modifier.padding(0.dp).size(24.dp),
                icon = if (isShowTime) R.drawable.done_check else R.drawable.add_picture,
                description = "시간 표시",
                onClick = {
                    isShowTime = !isShowTime
                }
            )

            Spacer(Modifier.width(11.dp))

            Text(
                modifier = Modifier.fillMaxHeight(),
                text = "시간 표시",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                color = AndroidLarge17SpotColor
            )

            Spacer(Modifier.width(24.dp))

            CustomImageButton(
                modifier = Modifier.padding(0.dp).size(20.dp),
                icon = if (isLuna) R.drawable.done_check else R.drawable.add_picture,
                description = "음력 표시",
                onClick = {
                    isLuna = !isLuna
                }
            )

            Spacer(Modifier.width(11.dp))

            Text(
                modifier = Modifier.fillMaxHeight(),
                text = "음력",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                color = AndroidLarge17SpotColor
            )
        }

        Spacer(Modifier.height(34.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "여행지",
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
                icon = if (useDestination) R.drawable.on_btn else R.drawable.off_btn,
                description = "On and Off Button in Destination",
                onClick = {
                    useDestination = !useDestination
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        if (useDestination) {
            CustomEditText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = destination,
                onValueChange = {
                    destination = it
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
                icon = if (useCompanion) R.drawable.on_btn else R.drawable.off_btn,
                description = "On and Off Button",
                onClick = {
                    useCompanion = !useCompanion
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        if (useCompanion) {
            CustomEditText(
                text = companion,
                onValueChange = {
                    companion = it
                },
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "한줄평을 입력하세요",
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
                icon = if (useScheduler) R.drawable.on_btn else R.drawable.off_btn,
                description = "On and Off Button",
                onClick = {
                    useScheduler = !useScheduler
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        if (useScheduler) {
            CustomEditText(
                text = scheduler,
                onValueChange = {
                    scheduler = it
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

        Spacer(Modifier.height(19.dp))

        /** 작성된 정보를 기반으로 데이터를 추가 */
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                Modifier.weight(1f)
            ) {
                CustomImageButton(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    icon = R.drawable.add_floating_button,
                    description = "Add Button",
                    onClick = {}
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "하위 페이지 추가"
                )
            }
            /** 작성된 정보를 기반으로 데이터를 추가 */
            CustomButton(
                modifier = Modifier
                    .width(84.dp)
                    .height(40.dp)
                    .background(
                        color = ButtonBackgroundPurple,
                        shape = RoundedCornerShape(size = 8.dp)
                    ),
                onClick = {
                    /** 작성된 정보를 기반으로 데이터를 추가 */
                },
                content = "저장",
                contentSize = 14.sp,
                contentPadding = PaddingValues(horizontal = 28.dp, vertical = 13.dp),
                contentColor = White,
                containerColor = ButtonBackgroundPurple
            )
        }
    }
}

/** 음력 변환 방법을 api로 할지 아니면 library 추가할지 찾기 */
private fun solarToLuna(dateString : String, formatter : DateTimeFormatter) : String {
    val lunarCalendar = "2023.03.18"
    return lunarCalendar
}