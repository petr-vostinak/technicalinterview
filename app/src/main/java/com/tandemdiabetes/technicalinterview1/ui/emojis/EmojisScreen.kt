package com.tandemdiabetes.technicalinterview1.ui.emojis

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tandemdiabetes.technicalinterview1.domain.Emoji



@Composable
fun EmojisScreen(
    state: EmojisScreenState
) {
    var selectedEmoji by remember { mutableStateOf<Emoji?>(null) }

    AnimatedVisibility(
        visible = state.isLoading
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(120.dp)
            )
        }
    }

    AnimatedVisibility(
        visible = !state.isLoading
    ) {
        LazyColumn {
            items(
                count = state.list.size
            ) { index ->
                val emoji = state.list[index]
                EmojiRow(
                    modifier = Modifier.clickable {
                        selectedEmoji = emoji
                    },
                    emoji = emoji
                )
            }
        }
    }

    AnimatedVisibility(selectedEmoji != null) {
        selectedEmoji?.let {
            AlertDialog(
                title = {
                    Text(text = it.unicodeName)
                },
                text = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = it.character,
                        fontSize = 180.sp,
                        textAlign = TextAlign.Center
                    )
                },
                onDismissRequest = {
                    selectedEmoji = null
                },
                confirmButton = {},
                dismissButton = {}
            )
        }
    }
}


@Composable
fun EmojiRow(
    modifier: Modifier = Modifier,
    emoji: Emoji
) {
    Row(
        modifier = modifier
            .padding(vertical = 2.dp, horizontal = 8.dp)
    ) {
        Text(text = emoji.character)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = emoji.unicodeName)
    }
}

@Preview
@Composable
fun EmojiRowPreview() {
    val emoji = Emoji(
        slug = "grinning-face-with-big-eyes",
        character = "\ud83d\ude03",
        unicodeName = "grinning face with big eyes",
        codePoint = "1F603",
        group = "smileys-emotion",
        subGroup = "face-smiling"
    )
    EmojiRow(Modifier,emoji)
}

@Preview
@Composable
fun ScreenPreview() {
    val emoji = Emoji(
        slug = "grinning-face-with-big-eyes",
        character = "\ud83d\ude03",
        unicodeName = "grinning face with big eyes",
        codePoint = "1F603",
        group = "smileys-emotion",
        subGroup = "face-smiling"
    )
    EmojisScreen(
        EmojisScreenState(
            isLoading = false,
            list = listOf(
                emoji,
                emoji,
                emoji
            )
        )
    )
}

@Preview
@Composable
fun ScreenLoadingPreview() {
    EmojisScreen(
        EmojisScreenState(
            isLoading = true,
            list = listOf()
        )
    )
}
