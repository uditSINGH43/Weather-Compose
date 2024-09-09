package com.example.weather_composenew.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_composenew.ui.screens.WeatherViewModel
import com.example.weather_composenew.ui.screens.weatherscreen


enum class Window(val route: String) {
    Home("home"),
    Setting("settings")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm: WeatherViewModel = viewModel()
    val nc = rememberNavController()
    NavHost(navController = nc, startDestination = Window.Home.route) {
        composable(Window.Home.route) {
            weatherscreen(
                modifier = modifier,
                state = vm.state.collectAsState().value
            ) {
                nc.navigate(Window.Setting.route)
            }


        }
        composable(Window.Setting.route) {
            Text(text = "Settings not available")
        }
    }
}
