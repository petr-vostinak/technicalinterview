package com.tandemdiabetes.technicalinterview1.data

import com.tandemdiabetes.technicalinterview1.domain.Emoji
import com.tandemdiabetes.technicalinterview1.domain.EmojiRepository
import com.tandemdiabetes.technicalinterview1.network.EmojiApi

class EmojiRepositoryImpl(
    private val api: EmojiApi
) : EmojiRepository {

    override suspend fun fetchAllEmojis(): Result<List<Emoji>> {
        return try {
            api.fetchAllEmojis().let {
                return TODO("Implement the success case scenario")
            }
        } catch (e: Exception) {
            return TODO("Implement the failure case scenario")
        }
    }
}
