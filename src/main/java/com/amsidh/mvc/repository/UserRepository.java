package com.amsidh.mvc.repository;

import com.amsidh.mvc.repository.entity.Todo;
import com.amsidh.mvc.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT t FROM User u JOIN u.todos t WHERE u.username = :username AND t.todoId = :todoId")
    Optional<Todo> findTodoByUsernameAndTodoId(String username, Integer todoId);
}
