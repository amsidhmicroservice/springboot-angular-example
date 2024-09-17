package com.amsidh.mvc;

import com.amsidh.mvc.repository.UserRepository;
import com.amsidh.mvc.repository.entity.Todo;
import com.amsidh.mvc.repository.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class SpringbootAngularBackendApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAngularBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Delete all existing data");
        userRepository.deleteAll();
        log.info("Loading new dummy data");
        final List<User> users = userRepository.saveAll(loadInitialData());
        log.info("Display all dummy initial Data");
        users.forEach(user -> {
            try {
                log.info("{}", new ObjectMapper().writeValueAsString(user));
            } catch (JsonProcessingException e) {
                log.error("Exception occurred while displaying data {}", e.getMessage(), e);
                throw new RuntimeException(e);
            }
        });
    }

    private List<User> loadInitialData() {
        return Arrays.asList(
                User.builder().username("dummy").todos(Arrays.asList(
                        Todo.builder().todoId(1).description("Java Learning").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(2).description("Spring Learning").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(3).description("Springboot Learning").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(4).description("LomBok Learning").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(5).description("Angular Learning").isDone(false).targetDate(new Date()).build()
                )).build(),
                User.builder().username("anjali").todos(Arrays.asList(
                        Todo.builder().todoId(1).description("Kerala Trip").isDone(false).targetDate(new Date()).build(),
                        Todo.builder().todoId(2).description("Singapore Trip").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(3).description("Thailand Trip").isDone(false).targetDate(new Date()).build(),
                        Todo.builder().todoId(4).description("Dubai Trip").isDone(false).targetDate(new Date()).build(),
                        Todo.builder().todoId(5).description("Manali Trip").isDone(false).targetDate(new Date()).build()
                )).build(),
                User.builder().username("aditya").todos(Arrays.asList(
                        Todo.builder().todoId(1).description("Class 1").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(2).description("Class 2").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(3).description("Class 3").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(4).description("Class 4").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(5).description("Class 5").isDone(true).targetDate(new Date()).build(),
                        Todo.builder().todoId(6).description("Class 6").isDone(false).targetDate(new Date()).build(),
                        Todo.builder().todoId(7).description("Class 7").isDone(false).targetDate(new Date()).build(),
                        Todo.builder().todoId(8).description("Class 8").isDone(false).targetDate(new Date()).build()
                )).build()

        );
    }
}

