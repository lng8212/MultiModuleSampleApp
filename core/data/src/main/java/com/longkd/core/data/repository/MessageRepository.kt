package com.longkd.core.data.repository

import com.longkd.core.model.Message
import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 15:42 - 28/04/2024
 */
interface MessageRepository {
    fun getAllMessages(): Flow<List<Message>>
    suspend fun saveMessage(message: Message)
}