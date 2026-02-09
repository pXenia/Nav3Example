package com.example.tasklist.di

import com.example.tasklist.impl.data.TasksRepositoryImpl
import com.example.tasklist.impl.domain.TasksRepository
import com.example.tasklist.impl.domain.usecases.ChangeTasksStatusUseCase
import com.example.tasklist.impl.domain.usecases.ChangeTasksStatusUseCaseImpl
import com.example.tasklist.impl.domain.usecases.DeleteTaskUseCase
import com.example.tasklist.impl.domain.usecases.DeleteTaskUseCaseImp
import com.example.tasklist.impl.domain.usecases.GetAllTasksUseCase
import com.example.tasklist.impl.domain.usecases.GetAllTasksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class TaskListModule {
    @Binds
    @Singleton
    internal abstract fun bindTasksRepository(impl: TasksRepositoryImpl): TasksRepository

    @Binds
    internal abstract fun bindChangeTasksStatusUseCase(
        impl: ChangeTasksStatusUseCaseImpl
    ): ChangeTasksStatusUseCase

    @Binds
    internal abstract fun bindDeleteTaskUseCase(
        impl: DeleteTaskUseCaseImp
    ): DeleteTaskUseCase

    @Binds
    internal abstract fun bindGetAllTasksUseCase(
        impl: GetAllTasksUseCaseImpl
    ): GetAllTasksUseCase
}