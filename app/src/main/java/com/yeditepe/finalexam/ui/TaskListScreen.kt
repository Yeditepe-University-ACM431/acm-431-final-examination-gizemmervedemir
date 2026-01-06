package com.yeditepe.finalexam.ui

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel = viewModel()) {

    // TODO 3: Read task list from ViewModel
    val tasks = viewModel.tasks
    val navController = rememberNavController()

    Column {
        // TODO 4: Display task titles and completion status
        // Use a simple Column or LazyColumn
        tasks.forEach { task ->
            Row {
                TaskRow(task = task, navController = navController)
                Spacer(Modifier.width(12.dp))
                Text(text = if (task.isCompleted) "+" else "X")
                Spacer(Modifier.width(12.dp))
                Text(
                    text = "Toggle",
                    modifier = Modifier.clickable { viewModel.toggleTask(task.id) }
                )
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, navController: NavController) {

    Text(
        text = task.title,
        modifier = Modifier.clickable {
            // TODO 3: Navigate to detail screen with task title
            val encoded = Uri.encode(task.title)
            navController.navigate("taskDetail/$encoded")
        }
    )
}

