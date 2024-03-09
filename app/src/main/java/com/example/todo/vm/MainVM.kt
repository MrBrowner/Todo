package com.example.todo.vm

import androidx.lifecycle.ViewModel

class MainVM(): ViewModel() {

    val t1 = 123

    override fun onCleared() {
        super.onCleared()
        // clear resources here
    }
}