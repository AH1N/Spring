package com.example.TaskManager.Controller;


import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Service.TaskManagerServise;
import com.example.TaskManager.dto.TaskRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @RestController аннотация из Spring
 * @AllArgsConstructor Lomboc
 */
@RestController
@AllArgsConstructor
public class TaskController {
    /**
     * поле - экземпляр класса TaskManagerServise со всеми его методами для работы с задачами
     */
    private final TaskManagerServise taskManagerServise;

    /**
     * Метод удаляет задачу выборка по {id}
     * @DeleteMapping("/{id}") аннотация удаления по параметру(переменной) из Spring
     * @PathVariable получение переменной {id} в данном случае
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskManagerServise.deleteTask(id);
    }
    /**
     * Метод меняет Статус задачи выборка по {id}
     * @PutMapping("/{id}") аннотация по изменению в БД  по параметру(переменной) из Spring
     * @RequestBody Task task тело запроса (сушьность которую мы заберём из сторонего ресурса)
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskManagerServise.changeTaskStatus(id, task);
    }
    /**
     * метод возвращает список задачь выборка по {status}
     * @GetMapping("/status/{status}") аннотация Spring для получения сущьности по параметру {status}
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") String status){
        return taskManagerServise.findTasksByStatus(status);
    }
    /**
     *Метод добавляет задачу
     * TaskRequest taskRequest - экземпляр класса содержащий необходимые параметры запроса
     * @PostMapping("/add") - Аннотация Spring, пкбликация задачи в БД
     * из стороннего сервиса получаем taskRequest
     */
    @PostMapping("/add")
    public Task addTask(@RequestBody TaskRequest taskRequest) {
        return taskManagerServise.addTask(taskRequest);
    }
    /**
     *Метод получает список задач
     * @GetMapping("/Task") - Аннотация Spring
     */
    @GetMapping("/Task")
    public List<Task> getAllTasks(){
        return taskManagerServise.getAllTasks();
    }

}
