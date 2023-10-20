package com.example.techtitans
//
interface Destinations{
    val route: String
}

object Home: Destinations{
    override val route = "home"
}

object LoanApp: Destinations{
    override val route = "loanApp"
}

object CreditScore: Destinations{
    override val route = "creditScore"
}
//
//object RegForm: Destinations{
//    override val route = "regForm"
//}