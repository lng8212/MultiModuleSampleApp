package com.longkd.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: longkd
 * @Since: 15:58 - 28/04/2024
 */

@Entity("messages")
data class MessageLocalModel(
    @ColumnInfo(name = "content") val content: String?,
    @ColumnInfo(name = "create_at_ms") val createAtMs: Long?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}