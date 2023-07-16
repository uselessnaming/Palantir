package com.example.familyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.familyproject.AndroidLarge17.AndroidLarge47
import com.example.familyproject.AndroidLarge36.AndroidLarge36
import com.example.familyproject.AndroidLarge39.AndroidLarge39
import com.example.familyproject.AndroidLarge43.AndroidLarge43
import com.example.familyproject.AndroidLarge44.AndroidLarge44
import com.example.familyproject.Components.ProjectScreen
import com.example.familyproject.ui.theme.FamilyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            FamilyProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = ProjectScreen.AndroidLarge34.name
                    ){
                        composable(ProjectScreen.AndroidLarge34.name){
                            AndroidLarge34(navController)
                        }
                        composable(ProjectScreen.AndroidLarge35.name){
                            AndroidLarge35(navController)
                        }
                        composable(ProjectScreen.AndroidLarge36.name){
                            AndroidLarge36()
                        }
                        composable(ProjectScreen.AndroidLarge39.name){
                            AndroidLarge39()
                        }
                        composable(ProjectScreen.AndroidLarge43.name){
                            AndroidLarge43()
                        }
                        composable(ProjectScreen.AndroidLarge44.name){
                            AndroidLarge44()
                        }
                        composable(ProjectScreen.AndroidLarge47.name){
                            AndroidLarge47()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FamilyProjectTheme {
        AndroidLarge34(navController = rememberNavController())
    }
}