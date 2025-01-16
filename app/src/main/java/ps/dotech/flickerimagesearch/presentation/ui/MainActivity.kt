package ps.dotech.flickerimagesearch.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ps.dotech.flickerimagesearch.presentation.common.Constrains.PARAM_IMAGE_LINK
import dagger.hilt.android.AndroidEntryPoint
import ps.dotech.flickerimagesearch.presentation.ui.navgraph.Route
import ps.dotech.flickerimagesearch.presentation.theme.FlickerImageSearchTheme
import ps.dotech.flickerimagesearch.presentation.ui.home.HomeScreen
import ps.dotech.flickerimagesearch.presentation.ui.imagedetails.ImageDetailScreen
import ps.dotech.flickerimagesearch.presentation.ui.navgraph.NavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlickerImageSearchTheme {
                val isSystemInDarkMode = isSystemInDarkTheme()

                Box(modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()) {
                    NavGraph(startDestination = Route.AppStartNavigation.route)
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