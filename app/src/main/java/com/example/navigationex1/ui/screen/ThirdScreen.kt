package com.example.navigationex1.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationex1.ui.theme.NavigationEx1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(navigateUp: () -> Unit) {
    Scaffold(
        topBar = { MyAnotherTopBar(navigateUp) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAnotherTopBar(navigateUp: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Third Screen") },
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}

@Preview
@Composable
fun MyAnotherTopBarPreview() {
    NavigationEx1Theme {
        MyAnotherTopBar {}
    }
}

@Preview
@Composable
fun ThirdScreenPreview() {
    NavigationEx1Theme {
        ThirdScreen {}
    }
}

