package com.example.NoteManager.Controller;


import com.example.NoteManager.Model.Note;
import com.example.NoteManager.Service.NoteManagerService;
import com.example.NoteManager.dto.NoteRequest;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;

/**
 *@Data аннотация Lombok
 *@RestController аннотация Spring, объединяет аннотации @Controller и @ResponseBody,
 * позволяет обрабатывать HTTP-запросы и возвращать данные в виде HTTP-ответов]
 * @RequestMapping ("/notes") базовый маршрут (endpoint) для всех методов обработки запросов в этом контроллере.
 * все запросы будут начинаться с /notes
 */
@Data
@RestController
@RequestMapping("/notes")
public class NoteController {

    /**
     * Поле - экземпляр NoteManagerService noteManagerService
     */
    private final NoteManagerService noteManagerService;
    /**
     *@PostMapping аннотация указывает, что метод addNote обрабатывает HTTP POST запросы.
     * @param addNoteRequest принимает объект NoteRequest в теле запроса
     * @RequestBody NoteRequest addNoteRequest - данный объект будет извлечен из тела запроса
     * и использован в качестве аргумента для метода.
     * addNote из noteManagerService, добавляет новую заметку на основе предоставленного NoteRequest.
     * Результат этого вызова помещается в ResponseEntity с кодом состояния HTTP 200 (OK) с возвращенной заметкой
     * в теле ответа.
     * @return ResponseEntity<Note> - это класс из Spring Framework, используемый для представления HTTP-ответа.
     * Он позволяет контроллерам возвращать не только тело ответа, но и различные свойства ответа,
     * такие как статус код, заголовки и другую мета-информацию.
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody NoteRequest addNoteRequest) {
        return noteManagerService.addNote(addNoteRequest);
    }
    /**
     *Метод получения всех Заметок
     * @return ResponseEntity<List<Note>>
     */
    @GetMapping("/getall")
    public ResponseEntity<List<Note>> getAllNotes() {
        return noteManagerService.getAllNotes2();
    }
    /**
     *Метод получения Заметки по id
     * @param id параметр выборки
     * @return ResponseEntity<Note>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
       return noteManagerService.getNoteById2(id);
    }
    /**
     * Метод редактирования Заметки
     * @param id id параметр выборки
     * @param toUpdateNote_Data - данные пришедшие со стороннего сервися
     * @return ResponseEntity<Note>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> editNoteById(@PathVariable Long id, @RequestBody NoteRequest toUpdateNote_Data) {
        return noteManagerService.editNoteById2(id, toUpdateNote_Data);
    }

    /**
     *
     * @param id id параметр выборки
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        return noteManagerService.deleteNoteById2(id);
    }

}
