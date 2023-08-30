package com.example.familyproject.AndroidLarge39

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.AndroidLarge44.DiaryScreen
import com.example.familyproject.Components.CustomSpinner
import com.example.familyproject.Components.TopBar
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.White

@Composable
fun AndroidLarge39(){

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
        }

        //일기 >> DiaryScreen
        if (selectedItem == "일기"){
            DiaryScreen(

            )
        }
        //여행 >> TravelScreen
        else {

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