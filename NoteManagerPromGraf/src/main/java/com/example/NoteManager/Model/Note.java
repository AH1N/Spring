package com.example.NoteManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * @Data аннотация из Lombok
 * @Entity класс Note является сущностью базы данных
 * @Table(name = "notes") - класс Note отображается в таблицу с именем "notes" в БД
 */
@Data
@Entity
@Table(name = "notes")
public class Note {
    /**
     *@Id Обозначает поле id как первичный ключ
     * @GeneratedValue (strategy = GenerationType.IDENTITY) значение для поля id
     * будет генерироваться базой данных с помощью автоинкремента
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * @Column (name = "noteTittle",nullable = false)
     * поле noteTittle должно отображаться на столбец с именем "noteTittle"
     * в БД, не может быть пустым (nullable = false)
     * аналогично для
     * @Column (name = "noteTittle",nullable = false)
     */
    @Column(name = "NOTE_TITTLE",nullable = false)
    private String noteTittle;

    @Column(name = "content",nullable = false)
    private String content;
    /**
     * @Column(name = "creationDate")
     * поле cteationDate должно отображаться на столбец с именем "cteationDate"
     *      в БД, инициализируется текущей датой и временем при создании объекта
     *      (LocalDateTime cteationDate = now();)
     */
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate = now();

//    @PrePersist
//    protected void onCreate() {
//        this.creationDate = LocalDateTime.now();
//    }
}
