package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.ThinTextColor
import com.example.familyproject.ui.theme.White

@Composable
fun WarningDialog(

){
    Column(
        modifier = Modifier.width(316.dp)
            .height(132.dp)
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(Modifier.height(27.dp))

        Text(
            text = "이 일정을 삭제하시겠습니까?",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            color = ThickTextColor,
        )

        Spacer(Modifier.height(7.dp))

        Text(
            text = "삭제된 일정은 복구할 수 없습니다.",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
            color = ThinTextColor,
        )

        Spacer(Modifier.height(33.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 60.dp, end = 56.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "취소",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_bold)),
                color = ThickTextColor,
            )

            Text(
                text = "삭제?",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_bold)),
                color = ThickTextColor,
            )

        }
    }
}

@Preview
@Composable
fun TestWarningDialog(){
    FamilyProjectTheme {
        WarningDialog()
    }
}