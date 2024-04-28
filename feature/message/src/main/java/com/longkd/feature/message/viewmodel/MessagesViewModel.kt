package com.longkd.feature.message.viewmodel

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longkd.core.domain.GetSavedMessageUseCase
import com.longkd.core.domain.SaveMessageUseCase
import com.longkd.core.model.Message
import com.longkd.core.util.AppDispatcher
import com.longkd.core.util.DispatcherType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 16:26 - 28/04/2024
 */

@HiltViewModel
class MessagesViewModel @Inject constructor(
    @AppDispatcher(DispatcherType.IO) private val dispatcherIO: CoroutineDispatcher,
    getSavedMessageUseCase: GetSavedMessageUseCase,
    private val savedMessageUseCase: SaveMessageUseCase,
) : ViewModel() {
    val uiState: StateFlow<MessageUiState> = getSavedMessageUseCase()
        .map { messages ->
            MessageUiState.Success(messages)
        }.catch {
            MessageUiState.Error(it)
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            MessageUiState.Loading
        )


    fun saveMessage(message: Message) {
        viewModelScope.launch(dispatcherIO) {
            savedMessageUseCase(message)
        }
    }

}

@Immutable
sealed interface MessageUiState {
    data object Loading : MessageUiState
    data class Error(val throwable: Throwable) : MessageUiState
    data class Success(val data: List<Message>) : MessageUiState
}