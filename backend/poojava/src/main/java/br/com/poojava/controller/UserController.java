package br.com.poojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.poojava.models.UserModel;
import br.com.poojava.repository.UserRespository;
import br.com.poojava.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRespository repository;

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<?> readAll(){
        List<UserModel> users = service.getUsers();

        if (users.size() <= 0) {
            return ResponseEntity.badRequest().body("não ha usuarios cadastrados");
        }

        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<?> postuser(@RequestBody @Valid UserModel user) {
        return ResponseEntity.ok().body(service.postUser(user));
    }

    @PutMapping
    public ResponseEntity<?> putUser(@RequestBody @Valid UserModel userBody, @RequestParam(value = "email") String email) {
        return ResponseEntity.ok().body(service.putUser(userBody, email));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok().body(repository.deleteByEmail(email));
    }
}
