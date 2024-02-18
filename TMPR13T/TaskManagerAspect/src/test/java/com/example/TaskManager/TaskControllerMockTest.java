package com.example.TaskManager;

import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Controller.TaskController;
import com.example.TaskManager.Service.TaskManagerServise;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(TaskController.class)
public class TaskControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskManagerServise taskService;

    @Test
    public void getAllTasksTest() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setTask_title("Провести презентацию");
        task.setTask_status("В процессе");
        task.setEmployees(Collections.emptySet());

        Mockito.when(taskService.getAllTasks()).thenReturn(Arrays.asList(task));

        mockMvc.perform(get("/Task/Tasks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"task_title\": \"Провести презентацию\",\n" +
                        "    \"task_status\": \"В процессе\",\n" +
                        "    \"employees\": []\n" +
                        "  }\n" +
                        "]"));
    }

    @Test
    public void getTaskByIdTest() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setTask_title("Провести презентацию");
        task.setTask_status("В процессе");
        task.setEmployees(Collections.emptySet());

        Mockito.when(taskService.getTaskById(1L)).thenReturn(Optional.of(task));

        mockMvc.perform(get("/Task/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"task_title\": \"Провести презентацию\",\n" +
                        "  \"task_status\": \"В процессе\",\n" +
                        "  \"employees\": []\n" +
                        "}"));
    }

}
