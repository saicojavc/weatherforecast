package com.saico.weatherforecast.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.saico.navigation.Navigator
import com.saico.weatherforecast.ui.theme.WeatherforecastTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigation : Navigator

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showSplashScreen by remember { mutableStateOf(false) }
           val systemTheme = isSystemInDarkTheme()
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                delay(3000) // Espera 3 segundos
                showSplashScreen = false
            }
            WeatherforecastTheme(darkTheme = false) {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color =  MaterialTheme.colorScheme.surface
               ) {
                   if(showSplashScreen){
                       //SplashScreen
                   }else{

                   }
               }
            }
        }
    }
}

@Composable
private fun MainContainer(
    startDestination: String,
    navigator: Navigator
){
    val navController = rememberNavController()

    Column {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.weight(1.0f)
        ){

        }
    }
}

