package ps.dotech.flickerimagesearch.domain.usecases

import com.dotech.quotes.common.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import ps.dotech.flickerimagesearch.data.models.ImageItemDto
import ps.dotech.flickerimagesearch.data.models.SearchResponseDto
import ps.dotech.flickerimagesearch.domain.repositories.ImagesRepo
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FeatchImageDetailsUseCase @Inject constructor(
    private val repo: ImagesRepo
) {

    operator fun invoke(imageID: String): Flow<ResponseState<ImageItemDto>> = flow {
        try {
            emit(ResponseState.Loading())
//            val response = repo.searchImages(tags).first()
//            emit(ResponseState.Success(response))
        } catch (e: HttpException) {
            emit(ResponseState.Error(e.localizedMessage ?: "An unexpected error Msg domain", null))
        } catch (e: IOException) {
            emit(ResponseState.Error("Couldn't reach server. Check your internet Connection", null))

        }
    }
}