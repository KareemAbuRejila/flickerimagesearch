package ps.dotech.flickerimagesearch.presentation.common

import ps.dotech.flickerimagesearch.data.models.MediaDto
import ps.dotech.flickerimagesearch.domain.models.ImageItem

object Constrains {

    const val NETWORK_STATUS="networkStatus"
    const val IS_CONNECTED = "isConnected"

    const val PARAM_IMAGE_LINK = "ImgLink"


    val MOCK_IMG = ImageItem(
        author =  "nobody@flickr.com (\"Mac Spud\")",
        description = TODO(),
        link = "https://www.flickr.com/photos/macspud/54255022494/",
        media = MediaDto( "https://live.staticflickr.com/65535/54255022494_0ba648ff48_m.jpg"),
        published = "2025-01-08T19:43:32Z",
        title = "IMG_0999",
    )

}