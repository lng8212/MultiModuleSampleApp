package com.longkd.core.domain

import com.longkd.core.data.repository.MessageRepository
import com.longkd.core.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: longkd
 * @Since: 16:19 - 28/04/2024
 */
class SaveMessageUseCase @Inject constructor(private val messageRepository: MessageRepository) {
    suspend operator fun invoke(message: Message) = messageRepository.saveMessage(message)
}