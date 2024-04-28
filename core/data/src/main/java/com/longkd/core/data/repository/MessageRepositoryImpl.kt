package com.longkd.core.data.repository

import com.longkd.core.database.dao.MessageLocalModelDao
import com.longkd.core.database.mapper.asLocalModel
import com.longkd.core.database.mapper.asMessage
import com.longkd.core.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 15:42 - 28/04/2024
 */
class MessageRepositoryImpl @Inject constructor(private val messageLocalModelDao: MessageLocalModelDao) :
    MessageRepository {
    override fun getAllMessages(): Flow<List<Message>> {
        return messageLocalModelDao.getAllMessages().map { listModel ->
            listModel.map { localModel ->
                localModel.asMessage()
            }
        }
    }

    override suspend fun saveMessage(message: Message) {
        messageLocalModelDao.saveMessage(message.asLocalModel())
    }
}