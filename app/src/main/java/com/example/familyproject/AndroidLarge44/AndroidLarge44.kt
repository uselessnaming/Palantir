package com.example.familyproject.AndroidLarge44

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomOutlineEditText
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.TopBar
import com.example.familyproject.MonthCalendar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.Palette2
import com.example.familyproject.ui.theme.Palette3
import com.example.familyproject.ui.theme.Palette4
import com.example.familyproject.ui.theme.Palette5
import com.example.familyproject.ui.theme.Palette6
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.White
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun AndroidLarge44(
    monthCalendar : MonthCalendar
){
    val alarm = listOf(
        "test1"
    )

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

    //알람 정보
    var selectedAlarm by remember{mutableStateOf(alarm[0])}

    //하루종일 선택 여부
    var useAllDay by remember{mutableStateOf(false)}

    //음력 선택 여부
    var useLuna by remember{mutableStateOf(false)}

    //디데이 선택 여부
    var useDDay by remember{mutableStateOf(false)}

    //파레트 설정 상태
    var selectedColor by remember{mutableStateOf(Palette1)}

    //스크롤 상태
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.background(color = White)
    ) {
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "To-do list",
            backIcon = R.drawable.btn_back,
            description = "Back Button"
        )

        Column(
            modifier = Modifier.verticalScroll(
                state = scrollState
            ),
        ){
            Spacer(Modifier.height(20.dp))

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 19.dp)
            ) {
                CustomOutlineEditText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    hint = "일정을 입력하세요",
                    fontSize = 16.sp,
                    textColor = AndroidLarge17AmbientColor,
                    borderColor = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = SpinnerBorder,
                        unfocusedBorderColor = SpinnerBorder,
                    ),
                    borderShape = RoundedCornerShape(size = 5.dp)
                )

                Spacer(Modifier.height(22.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomImageButton(
                        modifier = Modifier.size(24.dp),
                        icon = R.drawable.calendar_picker,
                        description = "Date Picker",
                        onClick = {

                        }
                    )

                    Spacer(Modifier.width(21.dp))

                    Text(
                        //DatePicker Image에서 발생한 날짜를 받아오는 걸로 바꿔야 함
                        text = startDate,
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        /** 날짜를 정하고 확인하면 해당 날짜와 시간을 받아옴 */
                        text = startTime,
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Spacer(Modifier.width(45.dp))

                    if(useLuna){
                        Text(
                            text = "음력 날짜",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            color = AndroidLarge17AmbientColor
                        )
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                if(!useAllDay){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(Modifier.width(45.dp))

                        Text(
                            //DatePicker Image에서 발생한 날짜를 받아오는 걸로 바꿔야 함
                            text = endDate,
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 24.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                fontWeight = FontWeight(400),
                                color = AndroidLarge17AmbientColor,
                            )
                        )

                        Spacer(Modifier.weight(1f))

                        Text(
                            /** 날짜를 정하고 확인하면 해당 날짜와 시간을 받아옴 */
                            text = endTime,
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 24.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                fontWeight = FontWeight(400),
                                color = AndroidLarge17AmbientColor,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Spacer(Modifier.width(45.dp))

                        if(useLuna){
                            Text(
                                text = "음력 날짜",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                color = AndroidLarge17AmbientColor
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(22.dp))
                }

                Row(
                    modifier = Modifier
                        .height(22.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(modifier = Modifier.width(45.dp))

                    Row(
                        modifier = Modifier.width(90.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        CustomImageButton(
                            modifier = Modifier.size(20.dp),
                            icon = if (useAllDay) R.drawable.done_check else R.drawable.add_picture,
                            description = "하루종일",
                            onClick = {
                                useAllDay = !useAllDay
                            }
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        Text(
                            text = "하루종일",
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 22.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                fontWeight = FontWeight(400),
                                color = AndroidLarge17AmbientColor,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.width(60.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        CustomImageButton(
                            modifier = Modifier.size(20.dp),
                            icon = if(useLuna) R.drawable.done_check else R.drawable.add_picture,
                            description = "음력",
                            onClick = {
                                useLuna = !useLuna
                            }
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        Text(
                            text = "음력",
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 22.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                fontWeight = FontWeight(400),
                                color = AndroidLarge17AmbientColor,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier.width(74.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        CustomImageButton(
                            modifier = Modifier.size(20.dp),
                            icon = if(useDDay) R.drawable.done_check else R.drawable.add_picture,
                            description = "디데이",
                            onClick = {
                                useDDay = !useDDay
                            }
                        )
                        Spacer(modifier = Modifier.width(11.dp))
                        Text(
                            text = "디데이",
                            style = TextStyle(
                                fontSize = 15.sp,
                                lineHeight = 22.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                fontWeight = FontWeight(400),
                                color = AndroidLarge17AmbientColor,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                ) {
                    CustomImageButton(
                        modifier = Modifier.size(20.dp),
                        icon = R.drawable.repeater,
                        description = "Radio Button",
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "반복없음",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )
                }

                Spacer(Modifier.height(22.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.location),
                        contentDescription = "Location",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )

                    Spacer(Modifier.width(19.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "장소",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.memo),
                        contentDescription = "Memo",
                        modifier = Modifier
                            .width(24.dp)
                            .fillMaxHeight()
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "메모를 입력하세요",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.attatchment),
                        contentDescription = "Attach File",
                        modifier = Modifier
                            .width(24.dp)
                            .fillMaxHeight()
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "첨부 파일",
                        style = TextStyle(
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                            fontWeight = FontWeight(400),
                            color = AndroidLarge17AmbientColor,
                        )
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                /** Spinner의 Text값이 '사용자 설정'일 경우 Add Button이 속해있는 Row의 VerticalAlignment와 Height를 수정해서 밑으로 내리도록 */
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.alarm),
                            contentDescription = "alarm",
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(19.dp))

                        /** dropdown menu item의 크기를 맞춰야 함 */
                        CustomSpinner(
                            items = alarm,
                            modifier = Modifier,
                            onValueChange = {
                                selectedAlarm = it
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(38.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(Modifier.width(8.dp))

                        CustomImageButton(
                            modifier = Modifier.size(30.dp),
                            icon = R.drawable.add_floating_button,
                            description = "Add Alarm",
                            onClick = {
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.palette),
                        contentDescription = "palette",
                        modifier = Modifier
                            .width(24.dp)
                            .fillMaxHeight()
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color1),
                        contentDescription = "palette_item1",
                        tint = Palette1,
                        modifier = Modifier.clickable{
                            selectedColor = Palette1
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color2),
                        contentDescription = "palette_item2",
                        tint = Palette2,
                        modifier = Modifier.clickable{
                            selectedColor = Palette2
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color3),
                        contentDescription = "palette_item3",
                        tint = Palette3,
                        modifier = Modifier.clickable{
                            selectedColor = Palette3
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color4),
                        contentDescription = "palette_item4",
                        tint = Palette4,
                        modifier = Modifier.clickable{
                            selectedColor = Palette4
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color5),
                        contentDescription = "palette_item5",
                        tint = Palette5,
                        modifier = Modifier.clickable{
                            selectedColor = Palette5
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color6),
                        contentDescription = "palette_item6",
                        tint = Palette6,
                        modifier = Modifier.clickable{
                            selectedColor = Palette6
                        }
                    )
                }
            }
        }
    }
}

private fun dateToString(date : LocalDateTime) : String{
    return ""
}

private fun timeToString(date : LocalDateTime) : String{
    return ""
}

@Preview
@Composable
fun TestAndroidLarge44(){
    FamilyProjectTheme {
        AndroidLarge44(monthCalendar = MonthCalendar())
    }
}