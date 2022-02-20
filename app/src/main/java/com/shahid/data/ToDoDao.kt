package com.shahid.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(toDo: ToDo)

    @Delete
    suspend fun deleteTodo(toDo: ToDo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id: Int): ToDo?

    @Query("SELECT * FROM todo")
    fun getTodo(): Flow<List<ToDo>>
}