package ps.dotech.flickerimagesearch.data.remote.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ps.dotech.flickerimagesearch.data.remote.apis.FlickrApiService
import ps.dotech.flickerimagesearch.domain.repositories.ImagesRepo
import javax.inject.Inject

class ImagesRepoImpl @Inject constructor(private val api: FlickrApiService)
    : ImagesRepo{
    override fun searchImages(tags: String) = flow {
        emit(api.searchImages(tags))
    }.flowOn(Dispatchers.IO)
}