package com.example.TaskManager.dto;

import lombok.Data;
/**
 *Класс - Запрос. Экземпляр хранит параметры запроса
 */
@Data
public class TaskRequest {
    private String taskTitle;
    private String taskStatus;
    private Long employeeId;
}
