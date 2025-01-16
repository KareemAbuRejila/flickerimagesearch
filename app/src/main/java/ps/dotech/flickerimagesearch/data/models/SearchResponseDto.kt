package ps.dotech.flickerimagesearch.data.models

import com.google.gson.annotations.SerializedName
import ps.dotech.flickerimagesearch.domain.models.ImagesListResponse

data class SearchResponseDto(
    @SerializedName("description") val description: String = "",
    @SerializedName("generator") val generator: String = "",
    @SerializedName("items") val items: List<ImageItemDto>,
    @SerializedName("link") val link: String = "",
    @SerializedName("modified") val modified: String = "",
    @SerializedName("title") val title: String = ""
)
fun SearchResponseDto.toResponse() = ImagesListResponse(
    list = items.map { it.toImageItem() }
)