package com.longkd.core.util

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

/**
 * @Author: longkd
 * @Since: 20:38 - 28/04/2024
 */

@Stable
@JvmInline
value class StableWrapper<T>(val value: T)

@Immutable
@JvmInline
value class ImmutableWrapper<T>(val value: T)

@Stable
fun <T> T.toStableWrapper(): StableWrapper<T> = StableWrapper(this)

@Stable
fun <T> T.toImmutableWrapper(): ImmutableWrapper<T> = ImmutableWrapper(this)


