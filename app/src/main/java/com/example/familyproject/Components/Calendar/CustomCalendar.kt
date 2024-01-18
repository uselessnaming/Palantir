package com.example.familyproject

import androidx.compose.runtime.Composable
import com.example.familyproject.model.data.MonthCalendar

@Composable
fun CustomCalendar(
    monthCalendar : MonthCalendar,
    selectedDate : CalendarDay,
    onChangeSelectDate : (CalendarDay) -> Unit,
    isBottomNavClick : () -> Unit
){
//    val TAG = "CustomCalendar"
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ){
//        val days = monthCalendar.dayList.observeAsState()
//        Log.d(TAG,"days = ${days}")
//
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .height(21.dp),
//            horizontalArrangement = Arrangement.Start
//        ){
//            Text(text = "SUN",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "MON",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "TUE",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "WED",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "THU",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "FRI",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//            Text(
//                text = "SAT",
//                Modifier
//                    .fillMaxHeight()
//                    .weight(1f),
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//            )
//        }
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(7),
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .weight(1f)
//        ){
//            items(days.value!!){date ->
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .height(110.dp)
//                        .clickable {
//                            onChangeSelectDate(date)
//                        }
//                ){
//                    Column{
//                        Text(
//                            text = "${date.day}",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    onChangeSelectDate(date)
//                                }
//                                .height(35.dp)
//                                .padding(8.dp)
//                                .border(
//                                    border = if (date == selectedDate) BorderStroke(
//                                        width = 1.dp,
//                                        color = SpinnerBorder
//                                    ) else BorderStroke(width = 0.dp, color = Color.Transparent),
//                                    shape = CircleShape
//                                ),
//                            textAlign = TextAlign.Center,
//                            fontFamily = FontFamily(Font(R.font.gmarket_sans_ttf_medium)),
//                            color = if(date == selectedDate) SpinnerBorder else CalendarText
//                        )
//                    }
//                }
//            }
//        }
//        Row(
//            horizontalArrangement = Arrangement.End,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(end = 7.dp)
//                .height(50.dp)
//        ){
//            CustomImageButton(
//                modifier = Modifier,
//                icon = R.drawable.add_floating_button,
//                description = "Add FLoating Button",
//                onClick = isBottomNavClick
//            )
//        }
//    }
}