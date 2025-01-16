package ps.dotech.flickerimagesearch.presentation.ui.imagedetails

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ps.dotech.flickerimagesearch.domain.models.ImageItem
import ps.dotech.flickerimagesearch.domain.repositories.ImagesRepo
import ps.dotech.flickerimagesearch.domain.usecases.FeatchImageDetailsUseCase
import ps.dotech.flickerimagesearch.presentation.ui.ComponentUIState
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel@Inject constructor(
    private val useCase: FeatchImageDetailsUseCase,
    @ApplicationContext
    private val context: Context
): ViewModel() {

    private val _state = mutableStateOf(ComponentUIState<ImageItem>())
    val state : MutableState<ComponentUIState<ImageItem>> = _state


    fun fetchImage(imageItem: ImageItem) { _state.value = ComponentUIState(data = imageItem)}
}