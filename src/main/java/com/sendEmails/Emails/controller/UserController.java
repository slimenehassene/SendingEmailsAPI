package com.sendEmails.Emails.controller;

import com.sendEmails.Emails.model.HttpResponce;
import com.sendEmails.Emails.model.User;
import com.sendEmails.Emails.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpResponce> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.created(URI.create("")).body(
                HttpResponce.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("user", newUser))
                        .message("user created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }


    @GetMapping
    public ResponseEntity<HttpResponce> confimeUser(@RequestParam("token") String token) {
        Boolean isSuccess = userService.verifyToken(token);
        return ResponseEntity.ok().body(
                HttpResponce.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("success", isSuccess))
                        .message("account verified")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
