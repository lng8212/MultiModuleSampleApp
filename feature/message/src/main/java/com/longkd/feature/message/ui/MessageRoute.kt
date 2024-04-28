package com.longkd.feature.message.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.longkd.core.model.Message
import com.longkd.feature.message.viewmodel.MessagesViewModel

/**
 * @Author: longkd
 * @Since: 16:43 - 28/04/2024
 */

@Composable
fun MessageRoute(
    modifier: Modifier = Modifier,
    viewModel: MessagesViewModel = hiltViewModel(),
) {

    val messageUiState by viewModel.uiState.collectAsStateWithLifecycle()
    MessageScreen(modifier, messageUiState, onSave = {
        viewModel.saveMessage(Message(it, System.currentTimeMillis()))
    })
}