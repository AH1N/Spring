CREATE TABLE employee (
      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
      EMPLOYEE_NAME VARCHAR(50) NOT NULL,
      TASKS_AMOUNT int
);

CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,
    task_status VARCHAR(255) NOT NULL,
    employeeId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (employeeId) REFERENCES Employee(id)
);

CREATE TABLE EMPLOYEE_TASKS (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    task_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (task_id) REFERENCES tasks(id)
);

