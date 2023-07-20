package com.example.familyproject.model.data

data class Todo(
    val time : String,
    val title : String,
    val description : String? = null,
    var isDone : Boolean = false,
)
