package ps.dotech.flickerimagesearch.presentation.ui.home

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import ps.dotech.flickerimagesearch.data.Utils.isNetworkAvailable
import ps.dotech.flickerimagesearch.data.models.toResponse
import ps.dotech.flickerimagesearch.domain.models.ImagesListResponse
import ps.dotech.flickerimagesearch.domain.repositories.ImagesRepo
import ps.dotech.flickerimagesearch.presentation.ui.ComponentUIState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ImagesRepo,
    @ApplicationContext
    private val context: Context
): ViewModel() {

    private val _images = mutableStateOf(ComponentUIState<ImagesListResponse>())
    val images : MutableState<ComponentUIState<ImagesListResponse>> = _images

    fun search(tags: String){
        if (isNetworkAvailable(context)){
            viewModelScope.launch {
                try {
                    val list = repo.searchImages(tags).collect{
                        _images.value = ComponentUIState(data = it.toResponse())
                    }
                }catch (e:Exception){
                    _images.value = ComponentUIState(error = e.message?:"Un known Error")
                }
            }
        }else{
            _images.value = ComponentUIState(error="No Internet Connection")
        }
    }
}