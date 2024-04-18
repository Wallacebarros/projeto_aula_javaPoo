package br.com.poojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.poojava.models.UserModel;
import br.com.poojava.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

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

    @GetMapping("/{email}")
    public ResponseEntity<?> readOne(@PathVariable String email){
        UserModel user = service.getUser(email);

        if (user == null) {
            return ResponseEntity.badRequest().body("Usuario não encontrado");
        }

        return ResponseEntity.ok(service.getuser(email));
    }

    @PostMapping
    public ResponseEntity<?> postuser(@RequestBody @Valid UserModel user) {
        return ResponseEntity.ok().body(service.postUser(user));
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> putUser(@RequestBody @Valid UserModel userBody, @PathVariable String email) {
        return ResponseEntity.ok().body(service.putUser(userBody, email));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam(value = "email") String email) {
        return ResponseEntity.ok().body(service.deleteUser(email));
    }
}
