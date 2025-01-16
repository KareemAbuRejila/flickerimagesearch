package ps.dotech.flickerimagesearch.presentation.common


sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object ImageDetailScreen: Screen("image_detail_screen")
}