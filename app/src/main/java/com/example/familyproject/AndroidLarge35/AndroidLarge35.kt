package com.example.familyproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.AndroidLarge35.CustomBottomSheetDialog
import com.example.familyproject.Components.CustomDatePickerDialog
import com.example.familyproject.Components.CustomTextButton
import com.example.familyproject.Components.CustomToolBar
import com.example.familyproject.Components.DrawerContent
import com.example.familyproject.model.data.MonthCalendar
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AndroidLarge35(
    navController : NavController,
    monthCalendar : MonthCalendar
){
    //화면 변수
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    var currentYearMonth by remember{mutableStateOf(monthCalendar.getDate())}
    var selectedDate by remember{ mutableStateOf(monthCalendar.today) }

    var showDialog by remember{mutableStateOf(false)}
    var isBottomNavClicked by remember{mutableStateOf(false)}
    var isMenuOpen by remember{mutableStateOf(false)}

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val coroutineScope = rememberCoroutineScope()

    //dialog 띄우기
    if (showDialog) {
        CustomDatePickerDialog(
            width = (screenWidth - 10).dp,
            height = (screenHeight * 0.7).dp,
            onDismiss = {
                showDialog = false
            },
            initDate = selectedDate,
            onChangeDate = {
                selectedDate = it
                monthCalendar.updateCalendar(it)
                currentYearMonth = monthCalendar.getDate()
            }
        )
    }

    if (isBottomNavClicked){
        CustomBottomSheetDialog(
            onDismissRequest = {
                isBottomNavClicked = !isBottomNavClicked
            },
            navController = navController,
        )
    }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet{
                DrawerContent()
            }
        },
        drawerState = drawerState,
        gesturesEnabled = true
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp),
        ){
            /** R.drawable.calendar_picker하고 three_dots_menu하고 switch */
            Column(
                modifier = Modifier.padding(top = 13.dp)
            ){
                CustomToolBar(
                    content = {
                        Row(
                            modifier = Modifier.clickable{
                                showDialog = true
                            },
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            CustomTextButton(
                                modifier = Modifier.clickable{
                                    isMenuOpen = !isMenuOpen
                                },
                                content = currentYearMonth,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                                textColor = ThickTextColor
                            )

                            Spacer(Modifier.width(8.dp))

                            IconButton(
                                modifier = Modifier.size(12.dp),
                                onClick = {
                                    showDialog = true
                                }
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.btn_toggle),
                                    contentDescription = "Show Dialog"
                                )
                            }
                        }
                    },
                    onMenuClick = {
                        coroutineScope.launch(Dispatchers.Main){
                            drawerState.open()
                        }
                    },
                )
                Spacer(modifier = Modifier.height(23.dp))

                CustomCalendar(
                    monthCalendar = monthCalendar,
                    selectedDate = selectedDate,
                    onChangeSelectDate = { date ->
                        if (selectedDate.month != date.month) {
                            currentYearMonth = monthCalendar.getDate()
                        }
                        selectedDate = date
                    },
                    isBottomNavClick = {
                        isBottomNavClicked = !isBottomNavClicked
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAndroid(){
    FamilyProjectTheme {
        AndroidLarge35(navController = rememberNavController(), MonthCalendar())
    }
}