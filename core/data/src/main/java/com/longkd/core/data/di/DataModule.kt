package com.longkd.core.data.di

import com.longkd.core.data.repository.MessageRepository
import com.longkd.core.data.repository.MessageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: longkd
 * @Since: 15:36 - 28/04/2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    internal abstract fun bindMessageRepository(messageRepositoryImpl: MessageRepositoryImpl): MessageRepository
}