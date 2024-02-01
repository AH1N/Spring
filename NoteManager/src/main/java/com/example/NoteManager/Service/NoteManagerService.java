package com.example.NoteManager.Service;

import com.example.NoteManager.Exception.BadRequestException;
import com.example.NoteManager.Exception.NoteNotFoundException;
import com.example.NoteManager.Model.Note;
import com.example.NoteManager.Repository.NoteRepository;
import com.example.NoteManager.dto.NoteRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * @Service аннотация из Spring , указывает, что NoteManagerService является сервисом.
 * содержат бизнес-логику
 * @Data аннотация Lombok
 */
@Service
@Data
public class NoteManagerService {
    /**
     * Поля - экземпляры Репозитория NoteRepository и Запроса NoteRequest
     */
    private final NoteRepository noteRepository;
    private final NoteRequest noteRequest;

    // TODO: 01.02.2024

    /**
     * Методы для проверки получаемых сущьностей
     * @param id
     * @return
     * start region
     */
    public boolean isValidNote(Long id){
        return getNoteById(id) != null;
    }

    public boolean isValidList(List<Note> listNote){
        return listNote != null || listNote.isEmpty();
    }
    /**
     * end region
     */

    /**
     * Сервис достаёт из базы Список сущьностей Note
     * @return List<Note>
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Альтернативный метод
     * @return ResponseEntity возхвращает ответ HTTP
     */
    public ResponseEntity<List<Note>> getAllNotes2() {
        List<Note> listNotes = noteRepository.findAll();

        if(this.isValidList(listNotes)){ return ResponseEntity.ok(listNotes);}
        return ResponseEntity.badRequest().build();
    }
    /**
     * Сервис Достаёт из БД сущьность Optional Note выборка по id
     * @param id параметр для выборки
     * @return Optional<Note> - если Заметки нет, то вернёт Null
     */
    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }
    /**
     * Альтернативный метод
     * @return ResponseEntity возхвращает ответ HTTP
     */
    public ResponseEntity<Note> getNoteById2(Long id){
        Optional <Note> currentNoteRequest = noteRepository.findById(id);
        if (this.isValidNote(id)) return ResponseEntity.ok(currentNoteRequest.get());
        return ResponseEntity.notFound().build();
    }
    /**
     * Удаление Note из БД
     * @param id параметр для выборки
     * @return true если Note была найдена и удалена,
     * в противном случае NoteNotFoundException()
     */
    /**
     * Метод удаления
     * @return ResponseEntity возхвращает ответ HTTP
     */
    public ResponseEntity<Void> deleteNoteById2(Long id) {
        Optional <Note> currentNoteRequest = noteRepository.findById(id);
        if (currentNoteRequest.isPresent()) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    /**
     * Изменение Заметки по id,
     * @param id id параметр для выборки
     * @param updateNote_data - Note которая получена со стороннего сервиса
     * @return Optional.of(existingNote) - измененную заметку
     * в противном случае NoteNotFoundException()
     */
    public Optional<Note> editNoteById(Long id, NoteRequest updateNote_data){
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isPresent()) {
            Note existingNote = optionalNote.get();
            existingNote.setNoteTittle(updateNote_data.getNoteTittle());
            existingNote.setContent(updateNote_data.getContent());

            return Optional.of(existingNote);

        } else throw new NoteNotFoundException();
    }

    /**
     * Альтернативный метод
     * @param id параметр для выборки
     * @param toUpdateNote_Data  Данные Note которая получена со стороннего сервиса
     * @return
     */
    public ResponseEntity<Note> editNoteById2(Long id, NoteRequest toUpdateNote_Data) {
        Optional <Note> optionalNote = noteRepository.findById(id);
        if(optionalNote.isPresent()){
            Note existingNote = optionalNote.get();
            existingNote.setNoteTittle(toUpdateNote_Data.getNoteTittle());
            existingNote.setContent(toUpdateNote_Data.getContent());
            return ResponseEntity.ok(existingNote);
        }
        return ResponseEntity.badRequest().build();
    }
    /**
     * Блок методов для создания Сущьности Note
     * @param noteRequest - Экземпляр Запроса NoteRequest noteRequest
     * @return createNote(noteRequest) - созданная Note
     * @addNote (NoteRequest noteRequest) - метод для NoteController
     * start region
     */
    public ResponseEntity<Note> addNote(NoteRequest noteRequest){
        return createNote(noteRequest);
    }
    private ResponseEntity<Note> createNote(NoteRequest noteRequest){
        if(noteRequest.isNoteRequest()){
            Note newNote = new Note();
            newNote.setNoteTittle(noteRequest.getNoteTittle());
            newNote.setContent(noteRequest.getContent());
            return saveNote(newNote);
        }
        else return ResponseEntity.badRequest().build();
    }
    /**
     * Сохранение newNote в БД
     * @param newNote - создана с помощью
     *                @createNote (NoteRequest noteRequest)
     */
    private ResponseEntity<Note> saveNote(Note newNote){
        return ResponseEntity.ok(newNote);
    }
    /**
     * end region
     */
}
