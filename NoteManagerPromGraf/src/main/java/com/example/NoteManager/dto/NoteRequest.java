package com.example.NoteManager.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Класс - Запрос. Экземпляр хранит параметры запроса
 * @Data - Аннотация Lombok
 */
@Component
@Data
public class NoteRequest {
    /**
     * Поля Запроса которые зпаолняются пользователем
     * @param noteTittle - Заполняется из запроса
     * @param content - Заполняется из запроса
     * @param cteationDate - заполняется автоматически
     * @param id - заполняется автоматически
     */

    private String noteTittle;
    private String content;

    /**
     * Метод для проверки правильности данных запроса
     * @return true если поля заполнены(не пустые)
     */
    public boolean isNoteRequest(){
        return noteTittle != null || content != null;
    }

}
