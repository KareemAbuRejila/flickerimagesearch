package ps.dotech.flickerimagesearch.domain.repositories

import kotlinx.coroutines.flow.Flow
import ps.dotech.flickerimagesearch.data.models.SearchResponseDto

interface ImagesRepo {
    fun searchImages(tags: String): Flow<SearchResponseDto>
}