package com.example.familyproject.Components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.familyproject.AndroidLarge39.AddPicturesPicker
import com.example.familyproject.R
import com.example.familyproject.ui.theme.FamilyProjectTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PicturePicker(
    modifier : Modifier = Modifier,
){
    var pageCount by remember{mutableStateOf(1)}
    val pagerState = rememberPagerState()
    var currentPage by remember{ mutableStateOf(0) }

    val imageList = mutableListOf<Uri>()

    var imageUri by remember{mutableStateOf<Uri?>(null)}

    val getImageContent = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    Column{
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ){
                IconButton(
                    onClick = {
                        if (currentPage == 0){
                            currentPage = pageCount-1
                        } else {
                            currentPage -= 1
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            }
            HorizontalPager(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                state = pagerState,
                pageCount = pageCount
            ) {page ->
                if (page == pageCount - 1){
                    AddPicturesPicker(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Black),
                        onAddClick = {
                            getImageContent.launch("image/*")
//                            pageCount += 1
//                            currentPage += 1
                        }
                    )
                } else {
                    val currentImageUri = imageList.getOrNull(page)
                    if(currentImageUri != null){
                        PictureCard(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.Green),
                            imageUri = imageUri ?: return@HorizontalPager
                        )
                    }
                }
            }
            IconButton(
                onClick = {
                    if (currentPage == pageCount - 1){
                        currentPage = 0
                    } else {
                        currentPage += 1
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next"
                )
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            items(pageCount){
                Icon(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Page Counter",
                    tint = if (it == currentPage) Color.Gray else Color.LightGray
                )
            }
        }
        imageUri?.let{ uri ->
            imageList.add(uri)
        }

        LaunchedEffect(currentPage){
            pagerState.scrollToPage(currentPage)
        }

        LaunchedEffect(imageUri){
            if(imageUri != null){
                imageList.add(imageUri!!)
                pageCount += 1
                currentPage += 1
            }
        }
    }
}

@Preview
@Composable
fun TestPicturePicker(){
    FamilyProjectTheme {
        val configuration = LocalConfiguration.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ){
            PicturePicker(modifier = Modifier.size(configuration.screenWidthDp.dp))
        }
    }
}