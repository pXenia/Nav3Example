package com.example.core.database.di

import com.example.core.database.NavDatabase
import com.example.core.database.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun provideTaskDao(database: NavDatabase): TaskDao = database.taskDao()
}
