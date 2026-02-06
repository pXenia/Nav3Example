package com.example.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.core.database.NavDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): NavDatabase = Room.databaseBuilder(
        context,
        NavDatabase::class.java,
        "nav_database",
    ).build()
}
