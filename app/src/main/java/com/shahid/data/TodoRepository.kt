package com.shahid.data
import kotlinx.coroutines.flow.Flow


//Job of this class to access all of the data sources - Which data should be forward to view model
interface TodoRepository {

    suspend fun insertTodo(toDo: ToDo)

    suspend fun deleteTodo(toDo: ToDo)

    suspend fun getTodoById(id: Int): ToDo?

    fun getTodo(): Flow<List<ToDo>>

}