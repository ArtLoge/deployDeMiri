package com.miris.deployDeMiri.controller;

import com.miris.deployDeMiri.model.UserModel;
import com.miris.deployDeMiri.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public ResponseEntity<?> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("users", userService.getAll());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody UserModel model) {
        Map<String, Object> response = new HashMap<>();
        response.put("user", userService.save(model));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/user")
    public ResponseEntity<?> update(@RequestBody UserModel model) {
        Map<String, Object> response = new HashMap<>();
        response.put("user", userService.update(model));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        response.put("users", userService.getById(id));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getAll(@PathVariable int id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
