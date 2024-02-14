package com.example.TaskManager.Repository;

import com.example.TaskManager.Model.Employe;
import com.example.TaskManager.Model.EmployeeTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * интерфейс Spring Data JPA методы для работы с базой данных, такие как сохранение, удаление,
 * поиск и обновление сущностей
 * набор методов для выполнения операций с базой данных, связанных со сущностью EmployeeTasks
 * @Repository предоставляет механизм для обнаружения,
 * настройки и управления объектов доступа к данным в вашем приложении,
 * делая их доступными для использования другими компонентами.
 */
@Repository
public interface EmployeeTasksRepository extends JpaRepository<EmployeeTasks, Long> {
}
