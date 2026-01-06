package com.yeditepe.finalexam.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.yeditepe.finalexam.model.Task

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    val tasks = mutableStateListOf(
        Task(id = 1, title = "Submit Final Project", isCompleted = false),
        Task(id = 2, title = "Review MVVM Notes", isCompleted = true)
    )

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val idx = tasks.indexOfFirst { it.id == taskId }
        if (idx != -1) {
            val t = tasks[idx]
            tasks[idx] = t.copy(isCompleted = !t.isCompleted)
        }
    }
}
