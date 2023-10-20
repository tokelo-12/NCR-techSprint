package com.example.techtitans

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.H
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navhost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Home.route,
        ){
        composable(route = Home.route){
            Landing()
        }
        composable(route = CreditScore.route){
            Screen()
        }



    }



}