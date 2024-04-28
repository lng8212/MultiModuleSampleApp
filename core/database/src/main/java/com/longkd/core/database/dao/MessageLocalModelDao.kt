package com.longkd.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.longkd.core.database.model.MessageLocalModel
import com.longkd.core.model.Message
import kotlinx.coroutines.flow.Flow

/**
 * @Author: longkd
 * @Since: 16:03 - 28/04/2024
 */
@Dao
interface MessageLocalModelDao {
    @Query("SELECT * FROM messages")
    fun getAllMessages(): Flow<List<MessageLocalModel>>
    @Insert
    fun saveMessage(messageLocalModel: MessageLocalModel)
}