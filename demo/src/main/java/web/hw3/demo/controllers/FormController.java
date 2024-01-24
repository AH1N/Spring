package web.hw3.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.hw3.demo.Domain.FormData;

@Controller
public class FormController {
    /**
     *
     * @param formData данные из полей доменного?? класса FormData
     * @return
     */
    @GetMapping("/input-form")
    public String showForm(FormData formData) {
        return "input-form";
    }

    /**
     *
     * @param formData Заполняем Форму на странице
     * @return переходим на страницу с результатом заполнения
     */
    @PostMapping("/submit-form")
    public String form(@ModelAttribute FormData formData) {
        return "result-page";
    }

}
