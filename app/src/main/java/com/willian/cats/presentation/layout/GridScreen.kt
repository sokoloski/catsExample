package com.willian.cats.presentation.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.willian.cats.presentation.CatsViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun GridScreen(
) {
    val viewModel = getViewModel<CatsViewModel>()
    val state by viewModel.state.collectAsState()

    state?.listOfCats?.let {
        Column {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(it) {
                    Image(
                        painter = rememberImagePainter(it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}
