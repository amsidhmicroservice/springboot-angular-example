package com.amsidh.mvc.controller;

import com.amsidh.mvc.exception.TodoNotFoundException;
import com.amsidh.mvc.exception.UserNotFoundException;
import com.amsidh.mvc.repository.UserRepository;
import com.amsidh.mvc.repository.entity.Todo;
import com.amsidh.mvc.repository.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*")
public class UserTodoController {

    private final UserRepository userRepository;

    @GetMapping("/{username}/todos")
    public User getAllToDosByUser(@PathVariable(name = "username") String username) {
        log.info("Inside getAllToDosByUser method");
        return userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
    }

    @PostMapping("/{username}/todos")
    public User saveTodo(@PathVariable(name = "username") String username, @RequestBody Todo todo) {
        log.info("Inside saveTodo method");
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
        final Optional<Todo> optionalTodo = user.getTodos().stream().filter(t -> t.getTodoId().equals(todo.getTodoId())).findFirst();
        if (optionalTodo.isPresent()) {
            Todo exisitingTodo = optionalTodo.get();
            Optional.of(todo.getTodoId()).ifPresent(exisitingTodo::setTodoId);
            Optional.of(todo.getDescription()).ifPresent(exisitingTodo::setDescription);
            Optional.of(todo.getIsDone()).ifPresent(exisitingTodo::setIsDone);
            Optional.of(todo.getTargetDate()).ifPresent(exisitingTodo::setTargetDate);
        } else {
            user.getTodos().add(todo);
        }
        userRepository.flush();
        return user;
    }

    @PutMapping("/{username}/todos/{todoId}")
    public User updateTodo(@PathVariable(name = "username") String username, @PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo) {
        log.info("Inside updateTodo method");
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
        user.getTodos().stream().filter(t -> t.getTodoId().equals(todoId)).findFirst().ifPresent(tt -> {
            Optional.ofNullable(todo.getDescription()).ifPresent(tt::setDescription);
            Optional.ofNullable(todo.getIsDone()).ifPresent(tt::setIsDone);
            Optional.ofNullable(todo.getTargetDate()).ifPresent(tt::setTargetDate);
        });
        userRepository.flush();
        ;
        return user;
    }

    @DeleteMapping("/{username}/todos/{todoId}")
    public User deleteTodo(@PathVariable(name = "username") String username, @PathVariable(name = "todoId") Integer todoId) {
        log.info("Inside deleteTodo method");
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
        user.getTodos().removeIf(todo -> todo.getTodoId().equals(todoId));
        userRepository.flush();
        return user;
    }

    @GetMapping("/{username}/todos/{todoId}")
    public Todo findTodoByUserNameAndTodoId(@PathVariable(name = "username") String username, @PathVariable(name = "todoId") Integer todoId) {
        log.info("Inside findTodoByUserNameAndTodoId method");
        return userRepository.findTodoByUsernameAndTodoId(username, todoId).orElseThrow(() -> new TodoNotFoundException(String.format("Todo with username %s and todoId %d not found", username, todoId)));
    }

}
