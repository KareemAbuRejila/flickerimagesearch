package ps.dotech.flickerimagesearch.presentation.ui

data class ComponentUIState<out T>(
    val isLoading: Boolean = false,
    val data: T?= null,
    val error: String = ""
)