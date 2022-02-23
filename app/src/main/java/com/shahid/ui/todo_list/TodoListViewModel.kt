package com.shahid.ui.todo_list

import androidx.lifecycle.ViewModel
import com.shahid.data.TodoRepository
import com.shahid.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    todoRepository: TodoRepository
): ViewModel() {

    val todos = todoRepository.getTodo()

    val _uiState = Channel<UiEvent> {}
    val uiEvent = _uiState.receiveAsFlow()

    fun onEvent(event: TodoListEvent) {
        when(event) {
            is TodoListEvent.OnTodoClick -> {

            }
            is TodoListEvent.OnAddTodolick -> {

            }
            is TodoListEvent.DeleteTodo -> {

            }
            is TodoListEvent.OnUndoDeleteClick -> {

            }

            is TodoListEvent.OnDoneChange -> {

            }

        }
    }
}