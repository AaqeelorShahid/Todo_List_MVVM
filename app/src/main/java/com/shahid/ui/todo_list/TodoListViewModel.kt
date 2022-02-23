package com.shahid.ui.todo_list

import androidx.lifecycle.ViewModel
import com.shahid.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    todoRepository: TodoRepository
): ViewModel() {

    val todos = todoRepository.getTodo()


}