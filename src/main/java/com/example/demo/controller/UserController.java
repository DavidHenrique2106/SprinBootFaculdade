package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private Map<String, String> userDatabase = new HashMap<>();

    @PostMapping
    public String createUser(@RequestBody Map<String, String> user) {
        String id = user.get("id");
        String name = user.get("name");
        userDatabase.put(id, name);
        return "Usuário criado: ID = " + id + ", Nome = " + name;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        String user = userDatabase.get(id);
        return user != null ? "Usuário encontrado: ID =     " + id + ", Nome = " + user : "Usuário com ID = " + id + " não encontrado.";
    }

    @GetMapping
    public Map<String, String> getAllUsers() {
        return userDatabase;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody Map<String, String> updatedUser) {
        if (userDatabase.containsKey(id)) {
            userDatabase.put(id, updatedUser.get("name"));
            return "Usuário atualizado: ID = " + id + ", Novo Nome = " + updatedUser.get("name");
        }
        return "Usuário com ID = " + id + " não encontrado.";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        if (userDatabase.containsKey(id)) {
            userDatabase.remove(id);
            return "Usuário com ID = " + id + " foi removido.";
        }
        return "Usuário com ID = " + id + " não encontrado.";
    }
}
