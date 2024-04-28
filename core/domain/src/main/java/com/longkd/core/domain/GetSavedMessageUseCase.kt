package com.longkd.core.domain

import com.longkd.core.data.repository.MessageRepository
import com.longkd.core.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 16:19 - 28/04/2024
 */
class GetSavedMessageUseCase @Inject constructor(private val messageRepository: MessageRepository){
    operator fun invoke(): Flow<List<Message>> = messageRepository.getAllMessages()
}