package com.example.familyproject.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme
import com.example.familyproject.ui.theme.SpinnerBorder

@Composable
fun CustomSpinner(
    items : List<String>,
    modifier : Modifier,
){
    var expanded by remember{ mutableStateOf(false) }
    var selectedItem by remember {mutableStateOf(items[0])}

    Column(
        modifier = modifier
    ){
        Row(
            modifier = Modifier
                .border(width = 0.5.dp, color = SpinnerBorder)
                .clickable { expanded = true },
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
                onClick = {}
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier
        ) {
            items.forEach{item ->
                DropdownMenuItem(onClick = {
                    selectedItem = item
                    expanded = false },
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
        CustomSpinner(
            items = listOf("Test"),
            modifier = Modifier)
    }
}