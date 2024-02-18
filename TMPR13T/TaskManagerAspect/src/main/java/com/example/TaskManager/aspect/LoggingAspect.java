package com.example.TaskManager.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);



    @Pointcut("within(com.example.TaskManager.Service.EmployeManagerService+)")
    public void anyEmployeeMethod() {}

    @Before("anyEmployeeMethod()")
    public void beforeAnyTaskManagerMethod(){
        LOGGER.info(">>> Используется метод Сервиса Для работы с клиентами <<<");
    }


    @Pointcut("within(com.example.TaskManager.Service.TaskManagerServise+)")
    public void anyTaskMethod() {}

    @Before("anyTaskMethod()")
    public void beforeАnyTaskMethod(){
        LOGGER.info(">>> Используется метод Сервиса Для работы с Задачами <<<");
    }


    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping com.example.TaskManager.Controller.TaskController+)")
    public void anyGetMapping() {}

    @Before("anyGetMapping()")
    public void beforeАnyGetMapping(){
        LOGGER.info(">>> Используется @GetMapping метод Контроллера Для работы с Задачами <<<");
    }

}
