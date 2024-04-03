package br.com.poojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.poojava.models.UserModel;
import br.com.poojava.repository.UserRespository;
// import jakarta.validation.Valid;

@RestController
// @Validated
public class UserController {
    
    @Autowired
    private UserRespository repository;

    @GetMapping("/user")
    public List<UserModel> getUsers() {
        return repository.findAll();
    }

    @PostMapping("/user")
    public UserModel puostUser(@RequestBody UserModel user) {
        return repository.save(user);
    }

    @PutMapping("/user")
    public UserModel putUser(@RequestBody UserModel userBody, @RequestParam(value = "email") String email) {
        UserModel user = repository.findByEmail(email);

        user.setName(userBody.getName());
        user.setEmail(userBody.getEmail());
        user.setPassword(userBody.getPassword());

        return repository.save(user);
    }
}
