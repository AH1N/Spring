-- Заполняем персонал
INSERT INTO employee (EMPLOYEE_NAME)
VALUES ('Иванов');
INSERT INTO employee (EMPLOYEE_NAME)
VALUES ('Петров');
INSERT INTO employee (EMPLOYEE_NAME)
VALUES ('Сидоров');


-- Заполняем Задачи персонала
-- Задачи для Иванова
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Выполнить отчёт', 'В процессе', 1);
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Провести совещание', 'Ожидание', 1);
-- Задачи для Петрова
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Подготовить презентацию', 'В процессе', 2);
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Провести презентацию', 'Ожидание', 2);
-- Задачи для Сидорова
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Подготовить отчёт по проекту', 'Завершено', 3);
INSERT INTO tasks (task_title, task_status, employeeId)
VALUES ('Провести тренинг', 'В ожидании', 3);


-- Заполняем таблицу связи задач с персоналом

-- Задачи для Иванова
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (1, 1);
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (1, 2);

-- Задачи для Петрова
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (2, 3);
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (2, 4);

-- Задачи для Сидорова
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (3, 5);
INSERT INTO EMPLOYEE_TASKS (employee_id, task_id) VALUES (3, 6);