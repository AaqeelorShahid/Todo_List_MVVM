package com.shahid.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImplementation (
    toDo: ToDo
        ) : TodoRepository {
    override suspend fun insertTodo(toDo: ToDo) {
        insertTodo(toDo)
    }

    override suspend fun deleteTodo(toDo: ToDo) {
        deleteTodo(toDo)
    }

    override suspend fun getTodoById(id: Int): ToDo? {
        return getTodoById(id)
    }

    override fun getTodo(): Flow<List<ToDo>> {
        return getTodo()
    }
}