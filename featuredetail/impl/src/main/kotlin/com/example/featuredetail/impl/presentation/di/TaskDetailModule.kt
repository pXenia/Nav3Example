package com.example.featuredetail.impl.presentation.di

import com.example.featuredetail.impl.presentation.data.TaskRepositoryImpl
import com.example.featuredetail.impl.presentation.domain.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TaskDetailModule {
    @Binds
    @Singleton
    abstract fun bindTaskRepository(impl: TaskRepositoryImpl): TaskRepository
}
