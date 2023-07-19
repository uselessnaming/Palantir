package com.example.familyproject.AndroidLarge35

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.Components.ProjectScreen
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetDialog(
    onDismissRequest : () -> Unit,
    navController: NavController,
){
    val modalBottomSheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    ){
        ModalBottomSheet(
            containerColor = White,
            contentColor = White,
            onDismissRequest = onDismissRequest,
            sheetState = modalBottomSheetState,
            dragHandle = {BottomSheetDefaults.DragHandle()},
            content = {
                Column (
                    modifier = Modifier
                        .background(
                            color = White,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        modifier = Modifier.clickable{
                            onDismissRequest()
                            navController.navigate(ProjectScreen.AndroidLarge43.name)
                        },
                        text = "to do list",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        modifier = Modifier.clickable{
                            onDismissRequest()
                            navController.navigate(ProjectScreen.AndroidLarge44.name)
                        },
                        text = "일정",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )
                    
                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        modifier = Modifier.clickable{
                            onDismissRequest()
                            navController.navigate(ProjectScreen.AndroidLarge39.name)
                        },
                        text = "다이어리",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )
                    Spacer(Modifier.height(40.dp))
                }
            }
        )
    }
}

@Preview
@Composable
fun TextBottomNav(){
    FamilyProjectTheme{
        Surface{
            CustomBottomSheetDialog(
                onDismissRequest = {},
                navController = rememberNavController()
            )
        }
    }
}