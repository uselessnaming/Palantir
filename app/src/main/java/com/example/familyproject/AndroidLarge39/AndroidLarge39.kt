package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.AndroidLarge44.DiaryScreen
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomLine
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.PicturePicker
import com.example.familyproject.Components.TopBar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.DescriptionText
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White

@Composable
fun AndroidLarge39(){

    //사진 click 상태 관리
    var isAddPicture by remember{ mutableStateOf(false) }

    //scroll 정보
    val configuration = LocalConfiguration.current

    //스크롤 상태
    val scrollState = rememberScrollState()

    //메뉴 아이템
    val menuList = listOf("일기","여행")

    //spinner에서 사용하는 아이템 상태
    var selectedItem by remember{mutableStateOf(menuList[0])}

    Column(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "다이어리",
            backIcon = R.drawable.btn_back,
            description = "Back Button"
        )

        /** verticalScroll을 Topbar는 고정시킨 채로 이용 */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp)
        ){
            Spacer(Modifier.height(20.dp))

            CustomSpinner(
                /** items : 다이어리의 title들을 모아놓은 list */
                items = menuList,
                modifier = Modifier.fillMaxWidth(),
                selectedItem = selectedItem,
                onValueChange = {
                    selectedItem = it
                }
            )

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                CustomImageButton(
                    modifier = Modifier.padding(0.dp),
                    icon = if (isAddPicture) R.drawable.done_check else R.drawable.add_picture,
                    description = "Add Picture Button",
                    onClick = {
                        isAddPicture = !isAddPicture
                    }
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

        if (isAddPicture) {
            Box(
                modifier = androidx.compose.ui.Modifier.size(configuration.screenWidthDp.dp)
            ) {
                PicturePicker(
                    modifier = Modifier.fillMaxSize()
                )
            }
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

        //일기 >> DiaryScreen
        if (selectedItem == "일기"){
            DiaryScreen(

            )
        }
        //여행 >> TravelScreen
        else {
            TravelScreen()
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