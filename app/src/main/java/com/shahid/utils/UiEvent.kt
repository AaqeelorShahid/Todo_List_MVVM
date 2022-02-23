package com.shahid.utils

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class snackBar (val message: String, val action: String? = null): UiEvent()
}
