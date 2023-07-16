package com.example.familyproject.AndroidLarge43

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomEditText
import com.example.familyproject.R
import com.example.familyproject.ui.theme.AndroidLarge17AmbientColor
import com.example.familyproject.ui.theme.DescriptionText
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.White

@Composable
fun AddSubJob(
){
    Row(
        modifier = Modifier.height(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            modifier = Modifier.size(20.dp),
            selected = false,
            onClick = { /* check logic */ },
            colors = RadioButtonDefaults.colors(AndroidLarge17AmbientColor)
        )

        Spacer(Modifier.width(22.dp))

        CustomEditText(
            modifier = Modifier.fillMaxHeight()
                .weight(1f),
            hint = "하위 작업을 입력하세요",
            fontSize = 15.sp,
            color = AndroidLarge17AmbientColor
        )
    }
}

@Composable
fun SubJob(){
    Row(
        modifier = Modifier.height(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            modifier = Modifier.size(20.dp),
            selected = false,
            onClick = { /* check logic */ },
            colors = RadioButtonDefaults.colors(AndroidLarge17AmbientColor)
        )

        Spacer(Modifier.width(22.dp))

        Text(
            /** AddSubJob에서 추가한 Text를 받아와서 text로 이용 */
            text = "하위 작업1",
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = DescriptionText,
            )
        )
    }
}

@Preview
@Composable
fun TestAddSubJob(){
    FamilyProjectTheme {
        Column(
            Modifier.fillMaxSize().background(color = White)
        ){
            AddSubJob()

            Spacer(Modifier.height(10.dp))

            SubJob()
        }
    }
}