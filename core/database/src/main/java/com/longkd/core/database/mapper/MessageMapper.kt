package com.longkd.core.database.mapper

import com.longkd.core.database.model.MessageLocalModel
import com.longkd.core.model.Message

/**
 * @Author: longkd
 * @Since: 16:01 - 28/04/2024
 */

fun Message.asLocalModel() = MessageLocalModel(this.content, this.createAtMs)
fun MessageLocalModel.asMessage() = Message(this.content ?: "", this.createAtMs ?: -1)