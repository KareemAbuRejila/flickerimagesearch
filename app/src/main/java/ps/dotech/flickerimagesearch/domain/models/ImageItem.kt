package ps.dotech.flickerimagesearch.domain.models

import ps.dotech.flickerimagesearch.data.models.MediaDto

data class ImageItem(
    val author: String,
    val description: String,
    val link: String,
    val media: MediaDto,
    val published: String,
    val title: String
)