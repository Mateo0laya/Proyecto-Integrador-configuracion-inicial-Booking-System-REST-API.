package com.example.demo.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findById(Integer.parseInt(id)));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName());
        userService.save(user);
        return ResponseEntity.ok("User Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody UserDTO userDTO) {
        User user = userService.findById(Integer.parseInt(id));
        user.update(userDTO.getName());
        userService.update(Integer.parseInt(id), user);
        return ResponseEntity.ok("User " + id + " Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userService.delete(Integer.parseInt(id));
        return ResponseEntity.ok("User " + id + " Deleted");
    }

}
