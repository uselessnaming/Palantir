package com.example.familyproject

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.familyproject.Components.CustomLine
import com.example.familyproject.Components.CustomOutlineButton
import com.example.familyproject.Components.CustomOutlineEditText
import com.example.familyproject.Components.CustomTextButton
import com.example.familyproject.Components.Logo
import com.example.familyproject.Components.ProjectScreen
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.Palette1
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.TextButtonColor
import com.example.familyproject.ui.theme.ThinTextColor
import com.example.familyproject.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidLarge34(
    navController : NavController
){
    val context = LocalContext.current

    var idState by remember{mutableStateOf("")}
    var passwdState by remember{mutableStateOf("")}

    Surface{
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 33.dp, end = 33.dp)
            ){
                Spacer(modifier = Modifier.height(125.dp))
                Logo(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp, end = 27.dp)
                )
                Spacer(modifier = Modifier.height(45.dp))
                CustomOutlineEditText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    hint = "아이디",
                    fontSize = 15.sp,
                    textColor = SpinnerBorder,
                    borderColor = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = SpinnerBorder,
                        unfocusedBorderColor = SpinnerBorder,
                    ),
                    onValueChange = {
                        idState = it
                    },
                    value = idState,
                    borderShape = RoundedCornerShape(size = 10.dp),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go)
                )
                Spacer(modifier = Modifier.height(10.dp))
                CustomOutlineEditText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    hint = "비밀번호",
                    fontSize = 15.sp,
                    textColor = SpinnerBorder,
                    onValueChange = {
                        passwdState = it
                    },
                    value = passwdState,
                    borderColor = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = SpinnerBorder,
                        unfocusedBorderColor = SpinnerBorder,
                    ),
                    borderShape = RoundedCornerShape(size = 10.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomOutlineButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Palette1, shape = RoundedCornerShape(size = 10.dp)),
                    content = "로그인",
                    contentSize = 16.sp,
                    contentColor = White,
                    contentPadding = PaddingValues(horizontal = 122.dp, vertical = 8.dp),
                    backgroundColor = ButtonDefaults.buttonColors(Palette1),
                    onClick = {
                        //input이 제대로 되었는지 확인
                        if(idState == ""){
                            message(context, "id를 입력해주세요")
                        } else if(passwdState == "") (
                            message(context, "passwd를 입력해주세요")
                        ) else {
                            // login 성공
                            if(login(idState, passwdState)){
                                Log.d("AndroidLarge34", "click done")
                                navController.navigate(ProjectScreen.AndroidLarge35.name)
                            }
                            // login 실패
                            else {
                                // Error Code : Error Message
                                val errorCode = ""
                                val errorMessage = ""
                                message(context, "$errorCode, $errorMessage")
                            }
                        }
                    },
                )

                Spacer(modifier = Modifier.height(31.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    CustomTextButton(
                        modifier = Modifier
                            .clickable {},
                        content = "회원가입",
                        fontSize = 15.sp,
                        textColor = TextButtonColor
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    CustomLine(
                        modifier = Modifier
                            .fillMaxHeight(),
                        type = "fully col",
                        strokeWidth = 2f
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    CustomTextButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {},
                        content = "아이디 찾기",
                        fontSize = 15.sp,
                        textColor = TextButtonColor
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomLine(
                        modifier = Modifier
                            .fillMaxHeight(),
                        type = "fully col",
                        strokeWidth = 2f
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomTextButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {},
                        content = "비밀번호 찾기",
                        fontSize = 15.sp,
                        textColor = TextButtonColor
                    )
                }

                Spacer(modifier = Modifier.height(31.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(26.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(Modifier.weight(1f))
                    Column(
                        modifier = Modifier.width(170.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        CustomTextButton(
                            modifier = Modifier
                                .clickable {
                                    //임시적으로 추가, 만약 이 기능으로 넘어갈 경우 알림 혹은 사용 불가능한 기능들이 따로 있음
                                    navController.navigate(ProjectScreen.AndroidLarge35.name)
                                },
                            content = "로그인 하지 않고 둘러보기",
                            fontSize = 14.sp,
                            textColor = ThinTextColor
                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Row(
                            Modifier.fillMaxWidth()
                        ){
                            CustomLine(
                                modifier = Modifier,
                                type = "fully row",
                                strokeWidth = 2f
                            )
                        }
                    }
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

private fun login(
    idValue : String,
    passwdValue : String
) : Boolean {

    /** 서버와 통신 >> idValue가 있는지 체크하고 passwdValue와 매칭이 되는 지 확인 */
    //

    return true
}

private fun message(context : Context, s : String){
    Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
fun Test(){
    FamilyProjectTheme {
        AndroidLarge34(navController = rememberNavController())
    }
}