package ps.dotech.flickerimagesearch.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ps.dotech.flickerimagesearch.data.models.MediaDto

@Parcelize
data class ImageItem(
    val author: String,
    val description: String,
    val link: String,
    val media: MediaDto,
    val published: String,
    val title: String
): Parcelable