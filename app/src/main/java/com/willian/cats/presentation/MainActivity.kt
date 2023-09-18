package com.willian.cats.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import coil.annotation.ExperimentalCoilApi
import com.willian.cats.presentation.di.injectCatsKoinModule
import com.willian.cats.presentation.di.injectNetWorkKoinModule
import com.willian.cats.presentation.layout.GridScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<CatsViewModel>()

    @OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            applicationContext
        }

        injectNetWorkKoinModule()
        injectCatsKoinModule()

        viewModel.interact(CatsInteraction.Open)
        setContent {
            GridScreen()
        }
    }
}
