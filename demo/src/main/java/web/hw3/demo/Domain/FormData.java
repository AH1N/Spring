package web.hw3.demo.Domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * модель формы "пользователя"
 * Используем Lomboc частично
 */
@Getter
@Setter
public class FormData {

    private String name;
    private String email;

}
