package ps.dotech.flickerimagesearch.presentation.ui.imagedetails

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ps.dotech.flickerimagesearch.R
import ps.dotech.flickerimagesearch.domain.models.ImageItem
import ps.dotech.flickerimagesearch.presentation.common.Constrains.MOCK_IMG
import ps.dotech.flickerimagesearch.presentation.common.Dimens.ImageHeight
import ps.dotech.flickerimagesearch.presentation.common.Dimens.MediumPadding1
import ps.dotech.flickerimagesearch.presentation.theme.FlickerImageSearchTheme
import ps.dotech.flickerimagesearch.presentation.ui.components.DetailsTopBar
import ps.dotech.flickerimagesearch.presentation.ui.components.ErrorBox
import ps.dotech.flickerimagesearch.presentation.ui.components.LoadingBox

@Composable
fun ImageDetailScreen(
    imageItem: ImageItem,
    viewModel: ImageDetailsViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
) {

    viewModel.fetchImage(imageItem)
    val state = viewModel.state.value

    when {
        state.isLoading -> LoadingBox()
        state.error.isNotBlank() -> ErrorBox(state.error, onClick = {})
        else -> state.data?.let {
            DetailsScreen(
                imageItem = it
            ) {navigateUp }
        }
    }

}

@Composable
fun DetailsScreen(imageItem: ImageItem, navigateUp: () -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(onBrowsingClick = {
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse(imageItem.media.url)
                if (it.resolveActivity(context.packageManager) != null) {
                    context.startActivity(it)
                }
            }
        }, onShareClick = {
            Intent(Intent.ACTION_SEND).also {
                it.putExtra(Intent.EXTRA_TEXT, imageItem.media.url)
                it.type = "text/plain"
                if (it.resolveActivity(context.packageManager) != null) context.startActivity(it)
            }
        }, onBookMarkClick = { }, onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1,
            )
        ) {
            item {
                AsyncImage(model = ImageRequest.Builder(context = context).data(imageItem.media.url)
                    .diskCacheKey("article-img-${imageItem.author},${imageItem.published}").build(),
                    contentDescription = "DetailsScreen-Art-Img",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                    onLoading = {})

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = imageItem.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.text_title)
                )

                Text(
                    text = imageItem.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenPreview() {
    FlickerImageSearchTheme {
        Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            DetailsScreen(
                imageItem = MOCK_IMG,
                navigateUp = { }
            )
        }
    }
}