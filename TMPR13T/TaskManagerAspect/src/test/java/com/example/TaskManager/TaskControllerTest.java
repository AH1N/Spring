package com.example.TaskManager;


import com.example.TaskManager.Model.Employe;
import com.example.TaskManager.Model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

@JsonTest
public class TaskControllerTest {

    @Autowired
    private JacksonTester<Task> json;

    @Test
    void taskSerializationTest() throws IOException {
        Task task = new Task();
        task.setId(1L);
        task.setTask_title("Провести презентацию");
        task.setTask_status("В процессе");
        task.setEmployees(new HashSet<>());

        assertThat(json.write(task)).isStrictlyEqualToJson(new ClassPathResource("e.json").getFile());
        assertThat(json.write(task)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(task)).extractingJsonPathNumberValue("@.id").isEqualTo(1);

        assertThat(json.write(task)).hasJsonPathStringValue("@.task_title");
        assertThat(json.write(task)).extractingJsonPathStringValue("@.task_title").isEqualTo("Провести презентацию");

        assertThat(json.write(task)).hasJsonPathStringValue("@.task_status");
        assertThat(json.write(task)).extractingJsonPathStringValue("@.task_status").isEqualTo("В процессе");

        assertThat(json.write(task)).hasJsonPathArrayValue("@.employees");
    }

}
