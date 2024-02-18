package com.example.TaskManager.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
/**
 * @Data аннотация из библиотеки Lombok, генерирует get/ser
 * @Entity Эта аннотация помечает класс как сущность, которая соответствует таблице в базе данных
 * @Table(name = "tasks") - аннотация Spring, обозначает что поля этого класса в таблице "tasks"
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {
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

    @Column(name = "task_title", nullable = false)
    private String task_title;

    @Column(name = "task_status", nullable = false)
    private String task_status;
    /**
     * @ManyToMany: Эта аннотация указывает на то, что у текущей сущности (в данном случае класс Task)
     * существует отношение "многие ко многим" с другой сущностью (в данном случае класс Employee).
     * Это означает, что одна задача может быть связана с несколькими сотрудниками, и наоборот,
     * один сотрудник может быть связан с несколькими задачами.
     *
     * @JoinTable: Эта аннотация используется для указания таблицы,
     * которая связывает записи из таблицы текущей сущности с записями из таблицы сущности, на которую она ссылается.
     * В данном случае, создается таблица с именем "employeeTasks",
     * которая будет содержать информацию о связях между задачами и сотрудниками.
     *
     * name = "employeeTasks": Этот атрибут определяет имя таблицы,
     * которая будет использоваться для связи между задачами и сотрудниками.
     *
     * joinColumns = @JoinColumn(name = "task_id"): Этот атрибут указывает столбец в таблице "employeeTasks",
     * который содержит ссылки на записи текущей сущности (т.е. таблицы "tasks").
     * Здесь "task_id" является ссылочным столбцом, связывающим текущую сущность с таблицей "employeeTasks".
     *
     * inverseJoinColumns = @JoinColumn(name = "employee_id"): Этот атрибут указывает столбец в таблице "employeeTasks",
     * который содержит ссылки на записи сущности Employee.
     * Здесь "employee_id" является ссылочным столбцом, связывающим сущность Employee с таблицей "employeeTasks".
     */
    @ManyToMany
    @JoinTable(
            name = "employeeTasks",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employe> employees = new HashSet<>();


}
