package com.example.TaskManager.Service;


import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Repository.TaskArchiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * !!!!Надо доработать!!!!
 */

@Service
@AllArgsConstructor
public class ArchiveTaskManagerService {

    private final TaskArchiveRepository taskArchiveRepository;

    public Optional<Task> getTaskById(Long id){

        return taskArchiveRepository.findById(id);
    }

    public List<Task> getAllArchiveTasks(){
        return taskArchiveRepository.findAll();
    }

    /**
     * CRUD
     */
    public Task createArchiveTask(Task task){
        return taskArchiveRepository.save(task);
    }

    /**
     * Тут возможно нужно просто заменить ей статус на невыполнено и вернуть в таблицу задач
     */
//    public Task updateArchiveTask(Long id, Task taskDetails){
//        Optional <Task> optionalTask = taskArchiveRepository.findById(id);
//        if(optionalTask.isPresent()){
//            Task task = optionalTask.get();
//            task.setTaskTitle(taskDetails.getTaskTitle());
//            task.setTaskStatus(taskDetails.getTaskStatus());
//            task.setTaskResponser(taskDetails.getTaskResponser());
//            return taskArchiveRepository.save(task);
//        }else {
//            throw new IllegalArgumentException("Task not found with id: " + id);
//        }
//    }

    public void deleteArchiveTask(Long id){
        taskArchiveRepository.deleteById(id);
    }

}
