package com.example.familyproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.SpinnerBorder
import com.example.familyproject.ui.theme.White

@Composable
fun CustomSpinner(
    items : List<String>,
    modifier : Modifier,
    selectedItem : String = items[0],
    onValueChange : (String) -> Unit,
    menuItemPadding : Dp = 0.dp
){
    var expanded by remember{ mutableStateOf(false) }

    Column(
        modifier = modifier.background(color = White)
    ){
        Row(
            modifier = Modifier
                .border(width = 0.5.dp, color = SpinnerBorder)
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = selectedItem,
            )
            CustomImageButton(
                modifier = Modifier,
                icon = R.drawable.btn_spinner,
                description = "Spinner Down",
                onClick = {
                    expanded = !expanded
                }
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier
                .padding(horizontal = menuItemPadding)
                .fillMaxWidth()
                .background(color = White)
                .border(width = 0.5.dp, color = Color.Black)
        ) {
            items.forEach{item ->
                DropdownMenuItem(
                    onClick = {
                        onValueChange(item)
                        expanded = false
                    },
                    text = {Text(item)}
                )
            }
        }
    }
}

@Preview
@Composable
fun TestSpinner(){
    FamilyProjectTheme {
        val items = listOf("Test1","Test2")
        var selectedItem by remember{mutableStateOf("")}
        CustomSpinner(
            items = items,
            modifier = Modifier,
            onValueChange = {
                selectedItem = it
            }
        )
    }
}