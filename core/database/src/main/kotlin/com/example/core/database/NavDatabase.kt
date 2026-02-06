package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.dao.TaskDao
import com.example.core.database.models.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class NavDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}