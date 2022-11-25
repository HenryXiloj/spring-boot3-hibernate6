package com.henry.controller;

import com.henry.model.User;
import com.henry.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String helloWorld() {

        return  """
                Hello World, 
                multi-line,
                text block.
                """;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/sum/{a}/{b}")
    public Integer getSum(@PathVariable int a, @PathVariable int b) {
        return userService.getSum(a, b);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

}
