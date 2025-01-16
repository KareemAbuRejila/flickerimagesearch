package ps.dotech.flickerimagesearch.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaDto(
    @SerializedName("m")
    val url: String
): Parcelable