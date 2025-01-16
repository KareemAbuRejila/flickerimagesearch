package ps.dotech.flickerimagesearch.data.models

import com.google.gson.annotations.SerializedName
import ps.dotech.flickerimagesearch.domain.models.ImageItem

data class ImageItemDto(
    @SerializedName("author")
    val author: String,

    @SerializedName("author_id")
    val authorId: String,

    @SerializedName("date_taken")
    val dateTaken: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("media")
    val media: MediaDto,

    @SerializedName("published")
    val published: String,

    @SerializedName("tags")
    val tags: String,

    @SerializedName("title")
    val title: String
)

fun ImageItemDto.toImageItem() = ImageItem(
    author = author,
    description = description,
    link = link,
    media = media,
    published = published,
    title = title
)