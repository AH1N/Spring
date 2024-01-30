package com.example.TaskManager.Model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Эту таблицу-сущьность нужно доделать
 */
@Data
@Entity
@Table(name = "TasksArchive")
public class TasksArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
