package com.yeditepe.finalexam.repository

import com.yeditepe.finalexam.api.TaskApi
import com.yeditepe.finalexam.model.Task

class TaskRepository(private val api: TaskApi) {

    suspend fun fetchTasks(): List<Task> {
        // TODO 1: Call API
        // TODO 2: Convert TaskDto list to Task list
        val dtos = runCatching { api.getTasks() }.getOrDefault(emptyList())

        return dtos.map { dto ->
            Task(
                id = dto.id,
                title = dto.title,
                isCompleted = dto.completed
            )
        }
    }
}

