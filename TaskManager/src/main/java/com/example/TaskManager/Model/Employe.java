package com.example.TaskManager.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @Data аннотация из библиотеки Lombok, генерирует get/ser
 * @Entity Эта аннотация помечает класс как сущность, которая соответствует таблице в базе данных
 * @Table(name = "employee") - аннотация Spring, обозначает что поля этого класса в таблице "employee"
 */
@Data
@Entity
@Table(name = "employee")
public class Employe {
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

    @Column(name = "EMPLOYEE_NAME",nullable = false)
    private String employeeName;

    @Column(name = "TASKS_AMOUNT",nullable = true)
    private Integer tasksAmount;

    @ManyToMany(mappedBy = "employees")
    private Set<Task> tasks = new HashSet<>();

}
