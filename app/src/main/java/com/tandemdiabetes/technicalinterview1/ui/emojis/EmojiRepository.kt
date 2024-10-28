package com.tandemdiabetes.technicalinterview1.ui.emojis

import com.tandemdiabetes.technicalinterview1.network.EmojiApi
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


class EmojiRepository @Inject constructor(
    private val emojiApi: EmojiApi
) {
    val emojis = MutableStateFlow(EmojisScreenState())

    suspend fun getEmojis() {
        // show loading
        emojis.value = EmojisScreenState(
            isLoading = true,
            list = listOf()
        )
        val list = emojiApi.fetchAllEmojis()

        // show data
        emojis.value = EmojisScreenState(
            isLoading = false,
            list = list
        )
    }
}