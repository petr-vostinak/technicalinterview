package com.tandemdiabetes.technicalinterview1.ui.emojis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmojisScreenViewModel @Inject constructor(
    private val repository : EmojiRepository
): ViewModel() {

    val screenState = repository.emojis.asStateFlow()

    fun getEmojis() {
        viewModelScope.launch {
            repository.getEmojis()
        }
    }

}
