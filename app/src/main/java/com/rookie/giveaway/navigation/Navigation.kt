package com.rookie.giveaway.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rookie.giveaway.Screens.HomeScreen
import com.rookie.giveaway.Screens.ProfileScreen
import com.rookie.giveaway.Screens.SearchScreen
import com.rookie.giveaway.SplashScreenFun

/*@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.SplashScreen.route) {
        composable(AppScreen.SplashScreen.route) { SplashScreen() }
        composable(AppScreen.MainActivity.route) { MainActivity(navController = navController) }
        *//*...*//*
    }
}*/

enum class Screens {
    SPLASH,
    HOME,
}
sealed class AppScreen(val route: String) {
    object Splash : AppScreen(Screens.SPLASH.name)
    object Home : AppScreen(Screens.HOME.name)
}

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppScreen.Splash.route
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppScreen.Splash.route
    ) {
        composable(AppScreen.Splash.route) {
            SplashScreenFun(navController)
        }
        composable(AppScreen.Home.route) {
            HomeScreen(navController)
        }
    }
}

sealed class BottomNavItem(val route: String, val title: String, val selectedIcon: ImageVector, val unselectedIcon:ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Filled.Home, Icons.Outlined.Home)
    object Search : BottomNavItem("search", "Search", Icons.Filled.Search, Icons.Outlined.Search)
    object Profile : BottomNavItem("profile", "Profile", Icons.Filled.Person, Icons.Outlined.Person)
}

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Home.route) { ProfileScreen() }
        composable(BottomNavItem.Search.route) { SearchScreen() }
        composable(BottomNavItem.Profile.route) { SearchScreen() }
    }
}