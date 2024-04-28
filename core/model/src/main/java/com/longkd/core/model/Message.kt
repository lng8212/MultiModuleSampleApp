package com.longkd.core.model

/**
 * @Author: longkd
 * @Since: 15:46 - 28/04/2024
 */

data class Message(val content: String, val createAtMs: Long) {
    override fun toString(): String {
        return "$content - $createAtMs"
    }
}