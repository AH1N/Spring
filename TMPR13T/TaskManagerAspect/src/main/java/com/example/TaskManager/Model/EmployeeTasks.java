package com.example.TaskManager.Model;


import jakarta.persistence.*;
import lombok.Data;

/**
 * Класс для таблицы связи между employee и task
 * @Data аннотация из библиотеки Lombok, генерирует get/ser
 * @Entity Эта аннотация помечает класс как сущность, которая соответствует таблице в базе данных
 * @Table(name = "employee") - аннотация Spring, обозначает что поля этого класса в таблице "employee"
 */
@Data
@Entity
@Table(name = "employeeTasks")
public class EmployeeTasks {
    /**
     * Аннотация @Id указывает, что поле id является первичным ключом сущности
     * Аннотация @GenerationType.IDENTITY означает,
     * что значение будет генерироваться в соответствии с правилами базы данных
     * (например, автоинкрементное поле в ДБ)
     * Атрибут nullable = false указывает,
     * что эти поля являются обязательными и не могут иметь значение null
     * Эти аннотации сообщают JPA о том,
     * как класс Book должен соотноситься с базой данных.
     * При использовании Spring Data JPA или других реализаций JPA
     * в Spring Framework, класс Book будет автоматически обнаружен как сущность
     * и интегрирован в приложение
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * @ManyToOne аннотация используется связи между текущей сущностью EmployeeTasks и сущностью,
     * на которую она ссылается (в данном случае сущность Employee
     * @JoinColumn(name = "employee_id", referencedColumnName = "id"):
     * Эта аннотация используется для указания столбца в таблице текущей сущности,
     * который содержит внешний ключ, связывающий её с сущностью Employee. Атрибут name = "employee_id" указывает,
     * что внешний ключ будет храниться в столбце employee_id таблицы текущей сущности.
     * Атрибут referencedColumnName = "id" указывает,
     * что этот внешний ключ ссылается на столбец id в таблице сущности Employee.
     * @ManyToOne и @JoinColumn связь "многие к одному" между текущей сущностью EmployeeTasks и
     * сущностью Employee на основе столбца employee_id в таблице EmployeeTasks,
     * который ссылается на столбец id в таблице Employee
     */
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employe employee;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;
}
