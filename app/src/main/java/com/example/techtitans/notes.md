### User Data

```kotlin
package com.example.librarycheckin.data

import java.time.LocalDateTime

//Hard-coded data
class User(
    val firstName: String,
    val lastName: String,
    val deviceId: String,
    val laptopMake: String,
    val identityNumber: Long,
    val date: LocalDateTime = LocalDateTime.now(),

    )

object UserData{
    var usersList = mutableListOf<User>(
        User(
            "Jokab",
            "Moryy",
            "drtg-345",
            "HP",
            979557563673753
        ),
        User(
            "Carrick",
            "Man",
            "dr65-345",
            "Lenovo",
            9796775563673753
        )
    )
    fun findUserById(identityNumber: Long?): User{
        return usersList.first{it.identityNumber == identityNumber}
    }
    fun findUserByName(firstName: String?){
        usersList.find{it.firstName == firstName}
    }
}

```


### App NavHost
```kotlin
package com.example.librarycheckin

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.librarycheckin.checkinspage.CheckInScreen
import com.example.librarycheckin.home.HomeScreen
import com.example.librarycheckin.registrationform.RegScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController ,
        startDestination = Home.route,
        modifier = modifier
    ){
        //builder parameter
        composable(route = Home.route){
            HomeScreen()
        }

        composable(route = CheckIns.route){
            CheckInScreen()
        }

        composable(route = RegForm.route){
            RegScreen()
        }
    }

}
```