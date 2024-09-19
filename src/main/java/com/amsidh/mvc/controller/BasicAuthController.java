package com.amsidh.mvc.controller;

import com.amsidh.mvc.controller.model.response.BasicAuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class BasicAuthController {

    @GetMapping("auth/{username}/{password}")
    public ResponseEntity<Object> handleUserAuth(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok().body(BasicAuthResponse.builder().message("User logged in successfully").build());
    }
}
