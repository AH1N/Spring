package com.example.NoteManager.Repository;

import com.example.NoteManager.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * интерфейс Spring Data JPA методы для работы с базой данных, такие как сохранение, удаление,
 * поиск и обновление сущностей
 * набор методов для выполнения операций с базой данных, связанных со сущностью Note
 * @Repository предоставляет механизм для обнаружения,
 * настройки и управления объектов доступа к данным в приложении,
 * делая их доступными для использования другими компонентами.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
