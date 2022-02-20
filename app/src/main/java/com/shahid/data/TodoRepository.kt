package com.shahid.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(toDo: ToDo)

    suspend fun deleteTodo(toDo: ToDo)

    suspend fun getTodoById(id: Int): ToDo?

    fun getTodo(): Flow<List<ToDo>>

}