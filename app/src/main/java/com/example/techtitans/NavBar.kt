package com.example.techtitans

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CreditScore
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.techtitans.ui.theme.TechTitansTheme

@Composable
fun NavBar(
    go : (Destinations) -> Unit
){
    val navContentColors = colorResource(id = R.color.navCnt)
    BottomAppBar(actions = {
        IconButton(onClick = { go(Home) }) {
            Icon(Icons.Filled.Home, contentDescription = "Localized description")
        }
        IconButton(onClick = { go(CreditScore) }) {
            Icon(
                Icons.Filled.CreditScore,
                contentDescription = "Localized description",
            )
        }
        IconButton(onClick = { /* do something */ }) {
            Icon(
                Icons.Filled.Edit,
                contentDescription = "Localized description",
            )
        }
    },
        containerColor = colorResource(id = R.color.navBG),
        contentColor = colorResource(id = R.color.navCnt),
        floatingActionButton = {
            FloatingActionButton(onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()) {

                Icon(Icons.Filled.Add, "Localized description")

            }
        },
    )
}

@Preview
@Composable
fun NavBarPreview(){
    TechTitansTheme {
        NavBar(go = {})
    }
}