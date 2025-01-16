package ps.dotech.flickerimagesearch.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ps.dotech.flickerimagesearch.R
import ps.dotech.flickerimagesearch.domain.models.ImageItem
import ps.dotech.flickerimagesearch.presentation.common.Constrains
import ps.dotech.flickerimagesearch.presentation.theme.FlickerImageSearchTheme

@Composable
fun ImageListItem(
    img: ImageItem, onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onItemClick(img.link) },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(img.media.url)
                    .crossfade(true).placeholder(R.drawable.placeholder).allowHardware(false)
                    .error(R.drawable.placeholder_error).build(),
                contentDescription = img.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)  // Ensure consistent aspect ratio
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

    }
}

@Preview(showBackground = true)
@Composable
fun ImageListItemPreview() {
    FlickerImageSearchTheme {
        ImageListItem(Constrains.MOCK_IMG) { }
    }
}
