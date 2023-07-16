package com.example.familyproject.AndroidLarge43

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.familyproject.Components.CustomEditText
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomOutlineEditText
import com.example.familyproject.Components.CustomRoundedCheckBox
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.TopBar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.DescriptionText
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.Palette2
import com.example.familyproject.ui.theme.Palette3
import com.example.familyproject.ui.theme.Palette4
import com.example.familyproject.ui.theme.Palette5
import com.example.familyproject.ui.theme.Palette6
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidLarge43(
){

    val alarmTimer = listOf(
        "알람 없음",
        "일정 시작 시간",
        "5분 전",
        "15분 전",
        "30분 전",
        "1시간 전",
        "1일 전",
        "2일 전",
        "1주 전",
        "사용자 설정",
    )

    val alarm = listOf(
        "test1"
    )

    /** 이해가 안된 화면 */
    
    Column(
        modifier = Modifier.background(color = White)
    ){
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "To-do list",
            backIcon = R.drawable.btn_back,
            description = "Back Button"
        )

        Spacer(Modifier.height(20.dp))

        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 19.dp)
        ){
            CustomOutlineEditText(
                modifier = Modifier
                    .fillMaxWidth(),
                hint = "할 일을 입력하세요",
                fontSize = 16.sp,
                textColor = AndroidLarge17AmbientColor,
                borderColor = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = SpinnerBorder,
                    unfocusedBorderColor = SpinnerBorder,
                ),
                borderShape = RoundedCornerShape(size = 5.dp)
            )

            Spacer(Modifier.height(19.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 13.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                CustomImageButton(
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    icon = R.drawable.add_floating_button,
                    description = "Add Sub Job",
                    onClick = {}
                )

                Spacer(Modifier.width(20.dp))

                Text(
                    text = "하위작업 추가",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = AndroidLarge17AmbientColor,
                    )
                )
            }

            Spacer(Modifier.height(34.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                CustomImageButton(
                    modifier = Modifier.fillMaxHeight(),
                    icon = R.drawable.calendar_picker,
                    description = "calendar_picker",
                    onClick = {}
                )

                Spacer(modifier = Modifier
                    .width(21.dp))

                Text(
                    //DatePicker Image에서 발생한 날짜를 받아오는 걸로 바꿔야 함
                    text = "2022. 11. 15 화요일",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = AndroidLarge17AmbientColor,
                    )
                )

                Spacer(Modifier.weight(1f))

                CustomRoundedCheckBox(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(18.dp)
                )

                Spacer(modifier = Modifier.width(11.dp))

                Text(
                    text = "음력",
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
            ){
                Icon(
                    painter = painterResource(id = R.drawable.repeater),
                    contentDescription = "repeat num",
                    modifier = Modifier
                        .width(24.dp)
                        .fillMaxHeight()
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
            ){
                Icon(
                    painter = painterResource(R.drawable.alarm_timer),
                    contentDescription = "Alarm Timer",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )

                Spacer(Modifier.width(19.dp))

                CustomSpinner(
                    items = alarmTimer,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            ){
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
            ){
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
            ){
                Row(
                    modifier = Modifier.fillMaxHeight()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.alarm),
                        contentDescription = "alarm",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(19.dp))

                    CustomSpinner(
                        items = alarm,
                        modifier = Modifier
                    )
                }
                Row(
                    modifier = Modifier.fillMaxHeight()
                        .width(38.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Spacer(Modifier.width(8.dp))

                    CustomImageButton(
                        modifier = Modifier.size(30.dp),
                        icon = R.drawable.add_floating_button,
                        description = "Add Alarm",
                        onClick = {}
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            ){
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
                    tint = Palette1
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.palette_color2),
                    contentDescription = "palette_item2",
                    tint = Palette2
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.palette_color3),
                    contentDescription = "palette_item3",
                    tint = Palette3
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.palette_color4),
                    contentDescription = "palette_item4",
                    tint = Palette4
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.palette_color5),
                    contentDescription = "palette_item5",
                    tint = Palette5
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.palette_color6),
                    contentDescription = "palette_item6",
                    tint = Palette6
                )
            }
        }
    }
}


@Preview
@Composable
fun TestAndroidLarge43(){
    FamilyProjectTheme{
        AndroidLarge43()
    }
}