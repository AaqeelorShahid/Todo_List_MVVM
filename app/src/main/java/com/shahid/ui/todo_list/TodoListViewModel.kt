package com.shahid.ui.todo_list

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahid.data.ToDo
import com.shahid.data.TodoRepository
import com.shahid.utils.Routes
import com.shahid.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    todoRepository: TodoRepository
): ViewModel() {

    val todos = todoRepository.getTodo()
    var repo = todoRepository

    val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var deletedTodo: ToDo? = null

    fun onEvent(event: TodoListEvent) {
        when(event) {
            is TodoListEvent.OnTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO + "?todoId=${event.toDo.id}"))
            }
            is TodoListEvent.OnAddTodoClick -> {
               sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }
            is TodoListEvent.DeleteTodo -> {
                viewModelScope.launch {
                    deletedTodo = event.todo
                    repo.deleteTodo(event.todo)
                    sendUiEvent(UiEvent.ShowSnackBar(
                        message = "ToDo Deleted",
                        action = "Undo"
                    ))
                }
            }
            is TodoListEvent.OnUndoDeleteClick -> {
                deletedTodo?.let { toDo ->
                    viewModelScope.launch {
                        repo.insertTodo(toDo)
                    }
                }
            }
            is TodoListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repo.insertTodo(event.todo.copy(
                        done = event.isDone
                    ))
                }
            }
        }
    }

    fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}