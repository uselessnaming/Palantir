package com.example.familyproject.AndroidLarge17

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.familyproject.AndroidLarge47.ThreeDotsMenu
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.Components.CustomRoundedCheckBox
import com.example.familyproject.Components.TopBar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.AndroidLarge17SpotColor
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.Palette2
import com.example.familyproject.ui.theme.Palette3
import com.example.familyproject.ui.theme.Palette4
import com.example.familyproject.ui.theme.Palette5
import com.example.familyproject.ui.theme.Palette6

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidLarge47(
    navController : NavController
){
    /** Three Dots Menu() */
    val menus = listOf("수정","복제","삭제")
    var menuState by remember{mutableStateOf(false)}
    var isMenuDown by remember{mutableStateOf(false)}

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier.shadow(
                    elevation = 10.dp,
                    spotColor = AndroidLarge17SpotColor,
                    ambientColor = AndroidLarge17AmbientColor
                ),
                title = "일정",
                backIcon = R.drawable.btn_back,
                description = "back",
            )
        }
    ){
        Surface(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(start = 19.dp, end = 19.dp)
            ){
                Row(
                    modifier = Modifier.padding(top = 13.dp, bottom = 13.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "장보기",
                        modifier = Modifier.padding(13.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomImageButton(
                        modifier = Modifier.size(20.dp),
                        icon = R.drawable.three_dots_menu,
                        onClick = {menuState = true},
                        description = "dots menu"
                    )
                }
                DropdownMenu(
                    modifier = Modifier,
                    expanded = menuState,
                    onDismissRequest = { menuState = false },
                ){
                    ThreeDotsMenu(
                        menus = menus,
                        isExpanded = isMenuDown,
                        onDismissRequest = {
                            isMenuDown = !isMenuDown
                        },
                        navController = navController,
                        navs = listOf() // 임시
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(147.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        CustomImageButton(
                            modifier = Modifier.size(24.dp),
                            icon = R.drawable.calendar_picker,
                            description = "calendar_picker",
                            onClick = {}
                        )
                    }
                    Spacer(modifier = Modifier
                        .width(21.dp)
                        .fillMaxHeight())
                    Column{
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                //DatePicker Image에서 발생한 날짜를 받아오는 걸로 바꿔야 함
                                text = "2022. 11. 15 화요일",
                                fontSize = 15.sp
                            )
                            Text(
                                //클릭하면 시간을 바꿀 수 있도록
                                modifier = Modifier.clickable{

                                },
                                text = "오후 5:00",
                                fontSize = 15.sp
                            )
                        }
                        Row{
                            Text(
                                //DatePicker에서 골라진 날짜를 바탕으로 음력으로 치환해서 계산
                                text = "(음)2022.11.27",
                                fontSize = 12.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(22.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                //DatePicker Image에서 발생한 날짜를 받아오는 걸로 바꿔야 함
                                text = "2022. 11. 15 화요일",
                                fontSize = 15.sp
                            )
                            Text(
                                //클릭하면 시간을 바꿀 수 있도록
                                modifier = Modifier.clickable{

                                },
                                text = "오후 6:00",
                                fontSize = 15.sp
                            )
                        }
                        Row{
                            Text(
                                //DatePicker에서 골라진 날짜를 바탕으로 음력으로 치환해서 계산
                                text = "(음)2022.11.27",
                                fontSize = 12.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(22.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            CustomRoundedCheckBox(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(11.dp))
                            Text(
                                text = "음력",
                                fontSize = 15.sp,
                                modifier = Modifier.fillMaxHeight()
                            )
                        }
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
                        painter = painterResource(id = R.drawable.repeater),
                        contentDescription = "repeat num",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "1주마다 (화, 목) 반복, 31회",
                        fontSize = 15.sp,
                        lineHeight = 24.sp
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
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "location",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "장소",
                        fontSize = 15.sp,
                        lineHeight = 24.sp
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
                        painter = painterResource(id = R.drawable.alarm),
                        contentDescription = "alarm",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Text(
                        //데이터 받아서 text 설정
                        text = "60시간 전, 일정 시작 시간",
                        fontSize = 15.sp,
                        lineHeight = 24.sp
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
                        painter = painterResource(id = R.drawable.palette),
                        contentDescription = "palette",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(21.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color1),
                        contentDescription = "palette_item1",
                        tint = Palette1
                    )

                    Spacer(modifier = Modifier.width(34.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color2),
                        contentDescription = "palette_item2",
                        tint = Palette2
                    )

                    Spacer(modifier = Modifier.width(34.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color3),
                        contentDescription = "palette_item3",
                        tint = Palette3
                    )

                    Spacer(modifier = Modifier.width(34.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color4),
                        contentDescription = "palette_item4",
                        tint = Palette4
                    )

                    Spacer(modifier = Modifier.width(34.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color5),
                        contentDescription = "palette_item5",
                        tint = Palette5
                    )

                    Spacer(modifier = Modifier.width(34.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.palette_color6),
                        contentDescription = "palette_item6",
                        tint = Palette6
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAndroidLarge47(){
    FamilyProjectTheme {
        AndroidLarge47(navController = NavController(LocalContext.current))
    }
}

