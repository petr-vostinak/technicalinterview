package com.tandemdiabetes.technicalinterview1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.tandemdiabetes.technicalinterview1.ui.emojis.EmojisScreen
import com.tandemdiabetes.technicalinterview1.ui.emojis.EmojisScreenViewModel
import com.tandemdiabetes.technicalinterview1.ui.theme.TechnicalInterview1Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /** View model */
    private val viewModel: EmojisScreenViewModel by lazy {
        ViewModelProvider(this)[EmojisScreenViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = viewModel.screenState.collectAsState()

            LaunchedEffect(Unit) {
                viewModel.getEmojis()
            }

            TechnicalInterview1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EmojisScreen(
                        state = state.value
                    )
                }
            }
        }
    }
}
