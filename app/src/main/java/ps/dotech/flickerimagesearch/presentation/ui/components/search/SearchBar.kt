package ps.dotech.flickerimagesearch.presentation.ui.components.search

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ps.dotech.flickerimagesearch.R
import ps.dotech.flickerimagesearch.presentation.common.Dimens.IconSize
import ps.dotech.flickerimagesearch.presentation.theme.FlickerImageSearchTheme


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    hint: String = "",
    ) {

    var searchInput by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier) {
        val containerColor = colorResource(id = R.color.input_background)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .searchBar(),
            value = searchInput,
            onValueChange = {
                searchInput = it
                onValueChange(it)
            },
            readOnly = readOnly,
            textStyle = MaterialTheme.typography.bodySmall,
            shape = MaterialTheme.shapes.medium,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            placeholder = {
                if (isHintDisplayed) {
                    Text(
                        text = hint)
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(IconSize).clickable { onClick?.invoke() },
                    tint = colorResource(id = R.color.body),
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                disabledTextColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

fun Modifier.searchBar(): Modifier = composed {
    if (!isSystemInDarkTheme()){
        border(
            width = 0.2.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    }else this@searchBar
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    FlickerImageSearchTheme {
        SearchBar(
            readOnly = false,
            onValueChange = {}
        )
    }
}