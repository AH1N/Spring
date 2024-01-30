package com.example.TaskManager.Service;

import com.example.TaskManager.Exception.EmployeeNotFoundException;
import com.example.TaskManager.Model.Employe;
import com.example.TaskManager.Model.EmployeeTasks;
import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Repository.EmployeRepository;
import com.example.TaskManager.Repository.EmployeeTasksRepository;
import com.example.TaskManager.Repository.TaskArchiveRepository;
import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.dto.TaskRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service: аннотация Spring Framework для пометки класса как сервисного компонента.
 * Когда класс помечен как @Service,
 * Spring обнаруживает его в процессе компоновки контейнера приложения и создает бин этого класса,
 * что позволяет использовать его в других компонентах приложения.
 * Класс TaskManagerServise предназначен для содержания бизнес-логики и обработки операций,
 * связанных с управлением сотрудниками (tasks).
 * @AllArgsConstructor - Lomboc
 */
@Service
@AllArgsConstructor
public class TaskManagerServise {

    /**
     * поля - экземпляры репозиториев
     */
    private final TaskRepository taskRepository;
    private final EmployeRepository employeRepository;
    private final EmployeeTasksRepository employeeTasksRepository;


    /**
     * Поиск Задачи по ID
     * @param id параметр по которому нужно искать
     * @return Optional<Task> предусмотрено что такой задачи может не быть
     */
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    /**
     * Изменение статусв задачи
     * @param id параметр по которому нужно искать
     * @param task - то что получаем со стороннего сервиса
     * @return createTask(task) - сохраняем задачу
     */
    public Task changeTaskStatus(Long id, Task task){
        Optional <Task> optionalTask = getTaskById(id);
        if(optionalTask.isPresent()) {
            Task newTask = optionalTask.get();
            newTask.setTask_status(task.getTask_status());
            return createTask(task);
        }else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Поиск Задач по Статусу
     * @param status
     * @return List<Task> - список задач
     */
    public List<Task> findTasksByStatus(String status) {
        return taskRepository.findTasksByStatus(status);
    }

    /**
     * Получение всех заявок
     * @return List<Task>
     */
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    /**
     * Создане задачи
     */
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    /**
     * Нужно доработать
     * Тут возможно нужно просто заменить ей статус на невыполнено и вернуть в таблицу задач
     */
//    public Task updateTask(Long id, Task taskDetails){
//        Optional <Task> optionalTask = taskRepository.findById(id);
//        if(optionalTask.isPresent()){
//            Task task = optionalTask.get();
//            task.setTask_title(taskDetails.getTask_title());
//            task.getTask_status()        setTaskStatus(taskDetails.getTaskStatus());
//            task.setTaskResponser(taskDetails.getTaskResponser());
//            return taskRepository.save(task);
//        }else {
//            throw new IllegalArgumentException("Task not found with id: " + id);
//        }
//    }

    /**
     * Удаление задачи по ID
     * @param id
     */
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    /**
     * Добавление задачи
     * @param taskRequest
     * @return
     */
    public Task addTask(TaskRequest taskRequest) {
        Optional<Employe> optionalEmployee = employeRepository.findById(taskRequest.getEmployeeId());
        if (optionalEmployee.isPresent()) {
            Task newTask = new Task();
            newTask.setTask_title(taskRequest.getTaskTitle());
            newTask.setTask_status(taskRequest.getTaskStatus());

            newTask = taskRepository.save(newTask); // Сохраняем задачу

            Employe employee = optionalEmployee.get();

            EmployeeTasks employeeTasks = new EmployeeTasks();
            employeeTasks.setTask(newTask);
            employeeTasks.setEmployee(employee);
            employeeTasksRepository.save(employeeTasks);

            return newTask; // Возвращаем созданную задачу
        } else {
            throw new EmployeeNotFoundException();
        }
    }

}
