package com.longkd.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.longkd.core.database.dao.MessageLocalModelDao
import com.longkd.core.database.model.MessageLocalModel

/**
 * @Author: longkd
 * @Since: 16:04 - 28/04/2024
 */
@Database(entities = [MessageLocalModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "MESSAGE_DB"
    }
    abstract fun getMessageLocalModelDao(): MessageLocalModelDao
}