package com.tandemdiabetes.technicalinterview1.domain

interface EmojiRepository {
    suspend fun fetchAllEmojis(): Result<List<Emoji>>
}
