package com.example.TaskManager.Repository;

import com.example.TaskManager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * интерфейс Spring Data JPA методы для работы с базой данных, такие как сохранение, удаление,
 * поиск и обновление сущностей
 * набор методов для выполнения операций с базой данных, связанных со сущностью EmployeeTasks
 * @Repository предоставляет механизм для обнаружения,
 * настройки и управления объектов доступа к данным в вашем приложении,
 * делая их доступными для использования другими компонентами.
 */
@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    /**
     * Не разобрался кк это правильно применить, доработаю
     * @return
     */
//    @Modifying
//    @Query("UPDATE tasks SET task_status = :status WHERE id = :id")
//    void changeTaskStatus(long id, String status);

    /**
     * @Query("SELECT t FROM Task t WHERE t.task_status = :status") - запрос JPA
     * метод сзздающий запрос в базу на выборку по полю task_status
     * @param status
     * @return
     */
    @Query("SELECT t FROM Task t WHERE t.task_status = :status")
    List<Task> findTasksByStatus(@Param("status") String status);
}
