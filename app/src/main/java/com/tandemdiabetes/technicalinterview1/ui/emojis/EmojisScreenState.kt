package com.tandemdiabetes.technicalinterview1.ui.emojis

import com.tandemdiabetes.technicalinterview1.domain.Emoji

class EmojisScreenState(
    val isLoading: Boolean = true,
    val list: List<Emoji> = listOf()
)
