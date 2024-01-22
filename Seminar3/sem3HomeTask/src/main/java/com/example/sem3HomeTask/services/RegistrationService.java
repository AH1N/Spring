package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    /**
     * Поля класса RegistrationService
     * @ dataProcessingService
     * @userService
     * @notificationService
     */
    @Autowired
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    /**
     *
     * @return экземпляр класса для обработки информации содержащейся в List<User> users
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * метод регистрации пользователя, но по факту просто добавления в список, не понимаю как тут работает регистрация
     * @param name имя пользователя
     * @param age возраст
     * @param email почта
     * notificationService.sendNotification("Пользователь добавлен");- наверное индикация что метод отработал
     *              в createUser есть уже нотификация
     *
     */
    public void processRegistration(String name, int age, String email) {
        dataProcessingService.addUserToList(userService.createUser(name,age,email));
        notificationService.sendNotification("Пользователь добавлен");
    }

}
