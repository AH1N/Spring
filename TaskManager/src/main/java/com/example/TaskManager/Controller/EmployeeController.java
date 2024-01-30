package com.example.TaskManager.Controller;


import com.example.TaskManager.Model.Employe;
import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Service.EmployeManagerService;
import com.example.TaskManager.Service.TaskManagerServise;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * EmployeeController Обрабатывает Сотрудников
 * @RestController - аннотация говорящая что это Rest лщнтроллер
 * @RequestMapping("/Employee") путь по которому тут всё выполняется
 * @AllArgsConstructor аннотация из Lombok
 */
@RestController
@RequestMapping("/Employee")
@AllArgsConstructor
public class EmployeeController {

    /**
     * поле - Экземпляр класса employeManagerService
     */
    private final EmployeManagerService employeManagerService;

    /**
     * Метод для получения списка сотрудников
     */
    @GetMapping()
    public List<Employe> getAllEmployee(){
        return employeManagerService.getAllEmployes();
    }

}
