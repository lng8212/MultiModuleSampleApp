package com.longkd.feature.message.ui

import android.util.Log
import android.widget.EditText
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.longkd.core.model.Message
import com.longkd.core.util.ImmutableWrapper
import com.longkd.feature.message.viewmodel.MessageUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.util.Date

/**
 * @Author: longkd
 * @Since: 16:44 - 28/04/2024
 */

@Composable
fun MessageScreen(
    modifier: Modifier = Modifier,
    messageUiState: MessageUiState,
    onSave: (name: String) -> Unit,
) {
    when (messageUiState) {
        is MessageUiState.Loading -> {
            CircularProgressIndicator(modifier = Modifier.requiredSize(60.dp))
        }

        is MessageUiState.Error -> {
            Text("An unexpected error has occurred: ${messageUiState.throwable}")
        }

        is MessageUiState.Success -> {
            MessageScreen(message = messageUiState.data.map {
                ImmutableWrapper(it)
            }.toImmutableList()) {
                onSave.invoke(it)
            }
        }
    }
}

@Composable
internal fun MessageScreen(
    modifier: Modifier = Modifier,
    message: ImmutableList<ImmutableWrapper<Message>>,
    onSave: (name: String) -> Unit,
) {
    var currentText by remember {
        mutableStateOf("")
    }
    Column {
        Text(text = "Insert", color = MaterialTheme.colorScheme.primary)
        TextField(modifier = Modifier.fillMaxWidth(), value = currentText, onValueChange = {
            currentText = it
        })
        Button(onClick = { onSave.invoke(currentText) }) {
            Text(text = "Save", color = Color.White)
        }
        LazyColumn {
            items(message, key = {
                it.hashCode()
            }) { message ->
                MessageItem(item = message)
            }
        }
    }

}

@Composable
internal fun MessageItem(modifier: Modifier = Modifier, item: ImmutableWrapper<Message>) {
    Column(modifier = modifier.padding(bottom = 8.dp)) {
        Text(text = item.value.content, color = MaterialTheme.colorScheme.primary)
        Text(text = Date(item.value.createAtMs).toString(), color = MaterialTheme.colorScheme.secondary)
    }

}