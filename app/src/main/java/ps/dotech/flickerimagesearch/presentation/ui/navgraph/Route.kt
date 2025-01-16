package ps.dotech.flickerimagesearch.presentation.ui.navgraph


sealed class Route(val route: String) {
    object AppStartNavigation : Route(route = "appStartNavigation")
    data object HomeScreen: Route("home_screen")
    data object ImageDetailScreen: Route("image_detail_screen")
}