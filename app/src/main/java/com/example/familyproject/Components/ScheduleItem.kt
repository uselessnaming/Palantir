package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.Gray3
import com.example.familyproject.ui.theme.Purple
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.TodoBackground

@Composable
fun ScheduleItem(
    time : String,
    title : String,
    description : String?,
    isDone : Boolean,
    onDoneClick : () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Gray3, shape = RoundedCornerShape(size = 10.dp))
            .background(
                color = if (isDone) Gray3 else TodoBackground,
                shape = RoundedCornerShape(size = 10.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 10.dp)
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = time,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_bold)),
                    fontWeight = FontWeight(500),
                    color = ThickTextColor
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                    textDecoration = if (isDone) TextDecoration.LineThrough else null,
                    color = ThickTextColor
                )

                if (description != null){
                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = description,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        fontWeight = FontWeight(400),
                        textDecoration = if (isDone) TextDecoration.LineThrough else null,
                        color = ThickTextColor
                    )
                }
            }

            Column(
                modifier = Modifier
                    .width(30.dp)
                    .padding(top = 19.dp)
            ){
                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = onDoneClick
                ) {
                    Icon(
                        painter = painterResource(if (!isDone) R.drawable.btn_done else R.drawable.done_check),
                        tint = if (isDone) Purple else LocalContentColor.current,
                        contentDescription = "Done Button"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestScheduleItem(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        ScheduleItem(
            time = "8:00 AM",
            title = "아침 스트레칭",
            description = "스트레칭 동영상은 유투브에서 보기",
            isDone = true,
            onDoneClick = {}
        )
    }
}