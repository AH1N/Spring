package web.hw3.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /**
     *  Метод запрос при переходе на страницу http://localhost:8080/
     *  шаблонг страницы
     * @return на страницу http://localhost:8080
     */
    @RequestMapping("/")
    public String hello1() {
        return "hello1";
    }
}

