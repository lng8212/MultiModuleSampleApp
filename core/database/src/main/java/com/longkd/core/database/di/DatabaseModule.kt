package com.longkd.core.database.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.longkd.core.database.AppDatabase
import com.longkd.core.database.dao.MessageLocalModelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: longkd
 * @Since: 16:07 - 28/04/2024
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMessageLocalModelDao(appDatabase: AppDatabase): MessageLocalModelDao =
        appDatabase.getMessageLocalModelDao()
}