package ps.dotech.flickerimagesearch.presentation.ui.navgraph

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ps.dotech.flickerimagesearch.domain.models.ImageItem
import ps.dotech.flickerimagesearch.presentation.common.Constrains.PARAM_IMAGE_LINK
import ps.dotech.flickerimagesearch.presentation.ui.home.HomeScreen
import ps.dotech.flickerimagesearch.presentation.ui.imagedetails.ImageDetailScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.HomeScreen.route
        ){
            composable(
                route = Route.HomeScreen.route
            ){ HomeScreen(
                navigateToDetailsScreen = { img ->
                    navigateToDetailsScreen(
                        navController = navController,
                        img = img
                    )
                    Toast.makeText(
                        context,
                        "${Route.ImageDetailScreen.route} + \"/${img.title}\"",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            }

            composable(
                route = Route.ImageDetailScreen.route
            ) {
                navController
                    .previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<ImageItem>("img")
                    ?.let {img->
                        ImageDetailScreen(
                            imageItem = img,
                        ){
                            navController.navigateUp()
                        }
                    }
            }

        }

    }
}

fun navigateToDetailsScreen(navController: NavHostController, img:ImageItem) {
    navController.currentBackStackEntry?.savedStateHandle?.set("img",img)
    navController.navigate(
        route = Route.ImageDetailScreen.route
    )
}
