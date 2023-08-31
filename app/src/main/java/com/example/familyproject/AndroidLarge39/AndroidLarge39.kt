package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.AndroidLarge44.DiaryScreen
import com.example.familyproject.Components.CustomButton
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomLine
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.PicturePicker
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
    navController : NavController
){

    //사진 click 상태 관리
    var isAddPicture by remember{ mutableStateOf(false) }

    //페이지 type 상태
    var pageType by remember{mutableStateOf("메인 페이지")}

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
    ){
        TopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "다이어리",
            backIcon = R.drawable.btn_back,
            description = "Back Button"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
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
                    },
                    menuItemPadding = 9.dp
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
                        modifier = Modifier.size(20.dp),
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

                    Spacer(Modifier.weight(1f))

                    CustomImageButton(
                        modifier = Modifier
                            .width(84.dp)
                            .height(22.dp),
                        icon = if (pageType == "메인 페이지") R.drawable.btn_main_page else R.drawable.btn_sub_page,
                        description = "페이지 타입",
                        onClick = {
                            pageType = if (pageType == "메인 페이지") "서브 페이지" else "메인 페이지"
                        }
                    )
                    /** 사진 추가 버튼을 누르면 PicturePicker 추가 */
                }
                Spacer(Modifier.height(14.dp))
            }

            if (isAddPicture) {
                Box(
                    modifier = Modifier.size(configuration.screenWidthDp.dp)
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
                DiaryScreen()
            }
            //여행 >> TravelScreen
            else {
                TravelScreen()
            }

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
                        /** 저장 클릭 시 어디로 이동 해야 하는지 */
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
}

@Preview
@Composable
fun TestAndroidLarge39(){
    FamilyProjectTheme {
        AndroidLarge39(
            navController = rememberNavController()
        )
    }
}