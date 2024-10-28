package com.tandemdiabetes.technicalinterview1.network

import com.tandemdiabetes.technicalinterview1.domain.Emoji
import retrofit2.http.GET

interface EmojiApi {

    @GET("/emojis?access_key=352a31dea84f985ea8f35049d2fb4d268310e14e")
    suspend fun fetchAllEmojis(): List<Emoji>
}
