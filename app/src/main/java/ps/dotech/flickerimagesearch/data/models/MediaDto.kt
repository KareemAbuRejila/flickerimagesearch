package ps.dotech.flickerimagesearch.data.models

import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("m")
    val url: String
)