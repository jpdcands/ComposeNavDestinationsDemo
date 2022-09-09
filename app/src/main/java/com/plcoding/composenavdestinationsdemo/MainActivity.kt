package com.plcoding.composenavdestinationsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.composenavdestinationsdemo.destinations.LoginScreenDestination
import com.plcoding.composenavdestinationsdemo.destinations.ScreenOneDestination
import com.plcoding.composenavdestinationsdemo.destinations.ScreenTwoDestination
import com.plcoding.composenavdestinationsdemo.ui.theme.ComposeNavDestinationsDemoTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavDestinationsDemoTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
                TopAppBar(
                    title = {
                        Text(text = "Compose - Destinations")
                    }
                )
            }
        }
    }
}
@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
       "Login Screen",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                  .padding(top = 160.dp, bottom = 140.dp)
                  .border(4.dp, Color.Black, RectangleShape)
                  .padding(15.dp)
        )
        Button(onClick = {
            navigator.navigate(
                ScreenOneDestination())
        }) {
            Text("Go to Screen 1")
        }
    }
}

@Destination
@Composable
fun ScreenOne(
    navigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Text("Screen 1",
           color = Color.Blue,
           fontWeight = FontWeight.Bold,
           textAlign = TextAlign.Center,
           fontSize = 50.sp,
           modifier = Modifier
               .padding(top = 100.dp, bottom = 140.dp)
               .border(4.dp, Color.Black, RectangleShape)
               .padding(15.dp)
       )
        Button(onClick = {
            navigator.navigate(ScreenTwoDestination())
        }) {
            Text("Go to Screen 2")
        }
    }
}
@Destination
@Composable
fun ScreenTwo(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 2",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(top = 160.dp, bottom = 140.dp)
                .border(4.dp, Color.Black, RectangleShape)
                .padding(15.dp)
        )
        Button(onClick = {
            navigator.navigate(LoginScreenDestination())
        }) {
            Text("Go to  LogIn Screen")
        }
    }
}