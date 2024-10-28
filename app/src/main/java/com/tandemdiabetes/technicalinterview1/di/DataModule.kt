package com.tandemdiabetes.technicalinterview1.di

import com.tandemdiabetes.technicalinterview1.di.NetworkModule.MainRetrofit
import com.tandemdiabetes.technicalinterview1.network.EmojiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideEmojiApi(
        @MainRetrofit retrofit: Retrofit
    ): EmojiApi {
        return retrofit.create(EmojiApi::class.java)
    }
}
