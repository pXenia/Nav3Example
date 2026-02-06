package com.example.featureone.impl.di

import com.example.featureone.impl.data.TasksRepositoryImpl
import com.example.featureone.impl.domain.TasksRepository
import com.example.featureone.impl.domain.usecase.ChangeTasksStatusUseCase
import com.example.featureone.impl.domain.usecase.ChangeTasksStatusUseCaseImpl
import com.example.featureone.impl.domain.usecase.DeleteTaskUseCase
import com.example.featureone.impl.domain.usecase.DeleteTaskUseCaseImp
import com.example.featureone.impl.domain.usecase.GetAllTasksUseCase
import com.example.featureone.impl.domain.usecase.GetAllTasksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class TasksModule {
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
