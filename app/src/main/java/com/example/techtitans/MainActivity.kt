package com.example.techtitans

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.techtitans.ui.theme.TechTitansTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechTitansTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Fintech()
                }
            }
        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Fintech() {
    val navController = rememberNavController()

// real time update of current stack
    val currentBackStack by navController.currentBackStackEntryAsState()
//Current Destination
    val currentDestination = currentBackStack?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavBar(
                go = { newScreen ->
                    navController.navigateSingleTopTo(
                        newScreen.route
                    )
                }
            )
        }
    ) { innerPadding ->
        Navhost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }
 }


fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route){
    popUpTo(
        this@navigateSingleTopTo.graph.findStartDestination().id
    ){
        saveState = true }
        launchSingleTop = true
        restoreState = true
}


@Preview
@Composable
fun HomePreview(){
    TechTitansTheme {
        Fintech()
    }
}

