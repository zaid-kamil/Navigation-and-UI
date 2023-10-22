package com.example.navigationex1.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationex1.ui.screen.FirstScreen
import com.example.navigationex1.ui.screen.SecondScreen
import com.example.navigationex1.ui.screen.ThirdScreen

enum class Screen {
    First,
    Second,
    Third
}

@Composable
fun Navigation() {
    // step 1: create a navController object
    val navController = rememberNavController()
    val enterTransition = slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
    NavHost(
        navController = navController,
        startDestination = Screen.First.name,
        enterTransition = { enterTransition },
    ) {
        composable(Screen.First.name) {
            FirstScreen(
                navigateToNext = {
                    navController.navigate(Screen.Second.name)
                }
            )
        }
        composable(Screen.Second.name) {
            SecondScreen(
                navigateForward = { navController.navigate(Screen.Third.name) },
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(Screen.Third.name) {
            ThirdScreen {
                navController.navigateUp()
            }
        }
    }
}