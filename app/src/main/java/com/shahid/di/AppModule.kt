package com.shahid.di

import android.app.Application
import androidx.room.Room
import com.shahid.data.ToDoDatabase
import com.shahid.data.TodoRepository
import com.shahid.data.TodoRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): ToDoDatabase {
        return Room.databaseBuilder(app, ToDoDatabase::class.java, "todo_database").build()
    }

    @Provides
    @Singleton
    fun provideTodoRepo(db: ToDoDatabase): TodoRepository {
        return TodoRepositoryImplementation(db.dao)
    }

}