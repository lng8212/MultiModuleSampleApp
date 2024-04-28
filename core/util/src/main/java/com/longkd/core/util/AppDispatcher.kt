package com.longkd.core.util

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

/**
 * @Author: longkd
 * @Since: 20:25 - 28/04/2024
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppDispatcher(val petDispatcher: DispatcherType)

enum class DispatcherType {
    Default,
    IO
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @AppDispatcher(DispatcherType.Default)
    fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @AppDispatcher(DispatcherType.IO)
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}