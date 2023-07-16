package com.example.familyproject.AndroidLarge35

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyproject.Components.CustomImageButton
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.ThickTextColor
import com.example.familyproject.ui.theme.White
import com.holix.android.bottomsheetdialog.compose.BottomSheetDialog
import com.holix.android.bottomsheetdialog.compose.BottomSheetDialogProperties
import com.holix.android.bottomsheetdialog.compose.NavigationBarProperties

@Composable
fun CustomBottomSheetDialog(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    ){
        BottomSheetDialog(
            onDismissRequest = {},
            properties = BottomSheetDialogProperties(
                dismissOnBackPress = true,
                navigationBarProperties = NavigationBarProperties(color = White),

            ),
            content = {
                Column (
                    modifier = Modifier.background(color = White, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    CustomImageButton(
                        modifier = Modifier,
                        icon = R.drawable.down_bottomsheet_dialog,
                        description = "Close BottomSheetDialog",
                        onClick = {}
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = "to do list",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = "일정",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )
                    
                    Spacer(modifier = Modifier.height(18.dp))

                    Text(
                        text = "다이어리",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
                        color = ThickTextColor
                    )

                    Spacer(modifier = Modifier.height(21.dp))
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
            CustomBottomSheetDialog()
        }
    }
}