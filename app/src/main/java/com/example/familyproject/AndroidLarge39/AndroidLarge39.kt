package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.familyproject.Components.CustomButton
import com.example.familyproject.Components.CustomEditText
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomLine
import com.example.familyproject.Components.CustomOnAndOffBtn
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.TopBar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.ButtonBackgroundPurple
import com.example.familyproject.ui.theme.DescriptionText
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White

@Composable
fun AndroidLarge39(
){
    Column(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize()
    ){
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "다이어리",
            backIcon = R.drawable.btn_back,
            description = "Back Button"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp)
        ){
            Spacer(Modifier.height(20.dp))

            CustomSpinner(
                /** items : 다이어리의 title들을 모아놓은 list */
                items = listOf("일기","여행"),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                CustomImageButton(
                    modifier = Modifier.padding(0.dp),
                    icon = R.drawable.add_picture,
                    description = "Add Picture Button",
                    onClick = {}
                )
                Spacer(Modifier.width(22.dp))

                Text(
                    text = "사진 추가",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = DescriptionText
                )

                /** 사진 추가 버튼을 누르면 PicturePicker 추가 */
            }
            Spacer(Modifier.height(14.dp))
        }
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp)
        ){
            Spacer(Modifier.height(18.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                CustomImageButton(
                    modifier = Modifier,
                    icon = R.drawable.calendar_picker,
                    description = "Date Picker",
                    onClick = {}
                )

                Spacer(Modifier.width(21.dp))

                /** 받아온 날짜로 변경 */
                Text(
                    text = "2022.11.15 화요일",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = AndroidLarge17SpotColor
                )

                Spacer(Modifier.weight(1f))

                CustomImageButton(
                    modifier = Modifier.padding(0.dp),
                    icon = R.drawable.add_picture,
                    description = "음력 체크",
                    onClick = {}
                )

                Spacer(Modifier.width(11.dp))

                /** 선택한 값으로 변경되도록 */
                Text(
                    text = "음력",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = AndroidLarge17SpotColor
                )
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Today's feeling",
                    fontSize = 15.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = DescriptionText
                )

                Spacer(Modifier.width(12.dp))

                CustomOnAndOffBtn(onClick = {})
            }

            Spacer(Modifier.height(6.dp))

            CustomEditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(start = 0.dp),
                hint = "오늘의 기분을 입력하세요",
                fontSize = 15.sp,
                color = DescriptionText
            )

            Spacer(Modifier.height(18.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "한줄 요약",
                    fontSize = 15.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    fontWeight = FontWeight(400),
                    color = DescriptionText
                )

                Spacer(Modifier.width(26.dp))

                CustomOnAndOffBtn(onClick = {})
            }

            Spacer(Modifier.height(6.dp))

            CustomEditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                hint = "한줄평을 입력하세요",
                fontSize = 15.sp,
                color = DescriptionText
            )

            Spacer(Modifier.height(28.dp))

            Text(
                text = "내용",
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = DescriptionText
            )

            CustomEditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                hint = "내용을 입력하세요",
                fontSize = 15.sp,
                color = DescriptionText
            )

            Spacer(Modifier.height(19.dp))

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                    Modifier.weight(1f)
                ){
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
                CustomButton(
                    modifier = Modifier.width(84.dp).height(40.dp)
                        .background(color = ButtonBackgroundPurple, shape = RoundedCornerShape(size = 8.dp)),
                    onClick = {  },
                    content = "저장",
                    contentSize = 14.sp,
                    contentPadding = PaddingValues(horizontal = 28.dp, vertical = 13.dp),
                    contentColor = White,
                    containerColor = ButtonBackgroundPurple
                )
            }

        }
    }
}

@Preview
@Composable
fun TestAndroidLarge39(){
    FamilyProjectTheme {
        AndroidLarge39()
    }
}