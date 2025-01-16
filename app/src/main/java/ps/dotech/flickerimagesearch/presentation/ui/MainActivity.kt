package ps.dotech.flickerimagesearch.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ps.dotech.flickerimagesearch.presentation.common.Constrains.PARAM_IMAGE_LINK
import dagger.hilt.android.AndroidEntryPoint
import ps.dotech.flickerimagesearch.presentation.common.Screen
import ps.dotech.flickerimagesearch.presentation.theme.FlickerImageSearchTheme
import ps.dotech.flickerimagesearch.presentation.ui.home.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlickerImageSearchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    Surface(color = MaterialTheme.colorScheme.background) {
                        val context = LocalContext.current
                        NavHost(
                            navController = navController,
                            startDestination = Screen.HomeScreen.route
                        ) {
                            composable(
                                route = Screen.HomeScreen.route
                            ) {
                                HomeScreen(
                                    navigateToDetailsScreen = { id ->
//                                    navController.navigate(Screen.ImageDetailScreen.route + "/${id}")
                                        Toast.makeText(
                                            context,
                                            "${Screen.ImageDetailScreen.route} + \"/${id}\"",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                )
                            }
                            composable(
                                route = Screen.ImageDetailScreen.route + "/{$PARAM_IMAGE_LINK}"
                            ) {
//                                ImageDetailsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlickerImageSearchTheme {
        Greeting("Android")
    }
}