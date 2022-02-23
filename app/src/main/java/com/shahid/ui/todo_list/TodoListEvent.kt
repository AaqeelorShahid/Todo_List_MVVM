package com.shahid.ui.todo_list

import com.shahid.data.ToDo

sealed class TodoListEvent {
    data class DeleteTodo (val todo: ToDo): TodoListEvent()
    data class OnDoneChange (val todo: ToDo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
    data class OnTodoClick (val toDo: ToDo): TodoListEvent()
}
