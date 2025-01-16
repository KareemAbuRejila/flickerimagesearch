package ps.dotech.flickerimagesearch.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ps.dotech.flickerimagesearch.presentation.common.Dimens.MediumPadding1
import ps.dotech.flickerimagesearch.presentation.ui.components.ErrorBox
import ps.dotech.flickerimagesearch.presentation.ui.components.ImageListItem
import ps.dotech.flickerimagesearch.presentation.ui.components.LoadingBox
import ps.dotech.flickerimagesearch.presentation.ui.components.search.SearchBar


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetailsScreen: (String) -> Unit,
){
    val state = viewModel.images.value

    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
    ) {
        SearchBar(
            onValueChange = { viewModel.search(it) }
        )
        when{
            state.isLoading ->  LoadingBox()
            state.error.isNotBlank() -> ErrorBox(state.error, onClick = {})
            else ->
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Adaptive(minSize = 180.dp)
                ) {
                    state.data?.list?.let {list->
                        items(list){img->
                            ImageListItem(img = img) {
                                navigateToDetailsScreen(img.link)
                            }
                        }
                    }
                }
        }
    }

}