package com.example.navigationex1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationex1.ui.theme.NavigationEx1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navigateToNext: () -> Unit // lambda function to handle onClick event
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Navigation App") })
    }, bottomBar = {
        BottomAppBar(
            actions = {
                IconButton(onClick = {
                    showBottomSheet = true
                }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = navigateToNext) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            })
    }) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding), contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "Welcome to 1st Screen", style = MaterialTheme.typography.displaySmall
                )
            }
        }
        if (showBottomSheet) {
            ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {

            }
        }
    }
}

@Preview
@Composable
fun FirstScreenPreiview() {
    NavigationEx1Theme {
        FirstScreen(
            navigateToNext = {}
        )
    }
}