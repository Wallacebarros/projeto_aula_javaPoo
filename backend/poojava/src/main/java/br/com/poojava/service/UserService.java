package br.com.poojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poojava.models.UserModel;
import br.com.poojava.repository.UserRespository;

@Service
public class UserService {

    @Autowired
    private UserRespository repository;

    public List<UserModel> getUsers() {
        return repository.findAll();
    }

    public UserModel getUser(String email) {
        return repository.findByEmail(email);
    }

    public UserModel getuser(String email) {
        return repository.findByEmail(email);
    }

    public UserModel postUser(UserModel newUser) {
        return repository.save(newUser);
    }

    public UserModel putUser(UserModel upUser, String email) {
        UserModel user = repository.findByEmail(email);

        user.setEmail(upUser.getEmail());
        user.setName(upUser.getName());
        user.setPassword(upUser.getPassword());

        return repository.save(user);
    }

    public UserModel deleteUser(String email) {
        return repository.deleteByEmail(email);
    }
}
