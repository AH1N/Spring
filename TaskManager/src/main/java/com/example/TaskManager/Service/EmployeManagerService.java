package com.example.TaskManager.Service;

import com.example.TaskManager.Model.Employe;
import com.example.TaskManager.Repository.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service: аннотация Spring Framework для пометки класса как сервисного компонента.
 * Когда класс помечен как @Service,
 * Spring обнаруживает его в процессе компоновки контейнера приложения и создает бин этого класса,
 * что позволяет использовать его в других компонентах приложения.
 * Класс EmployeManagerService предназначен для содержания бизнес-логики и обработки операций,
 * связанных с управлением сотрудниками (employe).
 * @AllArgsConstructor - Lomboc
 */
@Service
@AllArgsConstructor
public class EmployeManagerService {
    /**
     * Поле экземпляр репозитория EmployeRepository
     */
    private final EmployeRepository employeRepository;

    /**
     * Получение всех сотрудников из базы
     * @return List<Employe>
     */
    public List<Employe> getAllEmployes(){
        return employeRepository.findAll();
    }

    /**
     * Получение сотрудника по ID
     * @param id
     * @return Optional<Employe>(учитывается возможность того, что сотрудника с таким id нет)
     */
    public Optional<Employe> getEmployeById(Long id){
        return employeRepository.findById(id);
    }

    /**
     * Мохранение Сотрудника в БД
     * @param employe
     * @return Employe employe
     */
    public Employe createEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    /**
     * Обновление сотрудника
     * @param id - id сотрудника, данные которого надо поменять
     * @param employeDetails - то что получаем со стороннего сервиса
     * @return
     */
    public Employe updateEmploye(Long id, Employe employeDetails){
        Optional<Employe> optionalEmploye = employeRepository.findById(id);
        if (optionalEmploye.isPresent()) {
            Employe employe = optionalEmploye.get();
            employe.setEmployeeName(employeDetails.getEmployeeName());
            employe.setTasksAmount(employeDetails.getTasksAmount());
            return employeRepository.save(employe);
        } else {
            throw new IllegalArgumentException("Employe not found with id: " + id);
        }
    }

    /**
     * Удаление Сотрудника
     * @param id - параметр по которому нужно удалить
     */
    public void deleteEmploye(Long id){
        employeRepository.deleteById(id);
    }


}
