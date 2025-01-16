package ps.dotech.flickerimagesearch.data.remote.apis

import ps.dotech.flickerimagesearch.data.models.SearchResponseDto
import ps.dotech.flickerimagesearch.data.remote.Constrains.FEEDS
import ps.dotech.flickerimagesearch.data.remote.Constrains.GNE
import ps.dotech.flickerimagesearch.data.remote.Constrains.SERVICES
import ps.dotech.flickerimagesearch.data.remote.Constrains.FORMAT
import ps.dotech.flickerimagesearch.data.remote.Constrains.JSON
import ps.dotech.flickerimagesearch.data.remote.Constrains.NO_CALLBACK
import retrofit2.http.GET
import retrofit2.http.Query


interface FlickrApiService {

    @GET("$SERVICES/$FEEDS/$GNE?$FORMAT=$JSON&$NO_CALLBACK=1")
    suspend fun searchImages(@Query("tags") tags: String): SearchResponseDto
}
