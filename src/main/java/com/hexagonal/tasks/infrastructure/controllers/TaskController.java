package com.hexagonal.tasks.infrastructure.controllers;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.models.Tasks;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks body) {
        Tasks tasks = taskService.createTask(body);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Tasks> getById(@PathVariable long id){
        return taskService.getTaskById(id)
                .map(tasks -> new ResponseEntity<>(tasks, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks(){
        List<Tasks> tasksList = taskService.getAllTasks();
        return new ResponseEntity<>(tasksList, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public  ResponseEntity <Tasks> updateTask(@PathVariable long id ,@RequestBody Tasks body){
        return taskService.updateTasks(id, body)
                .map(tasks -> new ResponseEntity<>(tasks, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id){
        boolean taskDeleted = taskService.deleteTasks(id);
        if (taskDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{taskId}/additional-info")
    public ResponseEntity<AdditionalTasksInfo> getAdditionalTaskInfo(@PathVariable long id){
          AdditionalTasksInfo additionalTasksInfo = taskService.getAdditionalTasksInfo(id);
          return new ResponseEntity<>(additionalTasksInfo, HttpStatus.OK);
    }
}
