package com.example.familyproject.Components.Menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.familyproject.R
import com.example.familyproject.ui.theme.Black1
import com.example.familyproject.ui.theme.Blue1
import com.example.familyproject.ui.theme.Gray6
import com.example.familyproject.ui.theme.SpinnerBorder

@Composable
fun PopupDialog(
    width : Dp,
    height : Dp,
    title : String,
    content : String,
    leftButtonText : String,
    rightButtonText : String,
    onDismiss : () -> Unit,
    onLeftClick : () -> Unit,
    onRightClick : () -> Unit,
){
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .height(height)
                .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
                .padding(top = 19.dp, bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = title,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = Black1,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = content,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                fontWeight = FontWeight(400),
                color = Gray6,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(33.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ){
                Spacer(Modifier.weight(1f))

                Button(
                    modifier = Modifier.width(125.dp)
                        .fillMaxHeight(),
                    onClick = onLeftClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue1
                    ),
                    border = BorderStroke(width = 0.5.dp, color = SpinnerBorder),
                    shape = RoundedCornerShape(size = 7.dp)
                ) {
                    Text(
                        text = leftButtonText,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.width(26.dp))

                Button(
                    modifier = Modifier.width(125.dp)
                        .fillMaxHeight(),
                    onClick = onRightClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue1
                    ),
                    border = BorderStroke(width = 0.5.dp, color = SpinnerBorder),
                    shape = RoundedCornerShape(size = 7.dp)
                ) {
                    Text(
                        text = rightButtonText,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
fun TestPopupDialog(){

    var showDialog by remember{mutableStateOf(true)}

    if (showDialog) {
        PopupDialog(
            title = "등록하기",
            content = "추가할 항목을 선택해주세요",
            leftButtonText = "할 일",
            rightButtonText = "루틴",
            onDismiss = {
                showDialog = false
            },
            onLeftClick = {},
            onRightClick = {},
            width = 375.dp,
            height = 173.dp
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        TextButton(
            onClick = {
                showDialog = true
            }
        ) {
            Text(
                text = "Click"
            )
        }
    }
}
