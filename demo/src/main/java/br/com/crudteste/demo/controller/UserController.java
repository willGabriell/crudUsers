package br.com.crudteste.demo.controller;

import java.util.List;
import java.util.Optional;

import br.com.crudteste.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudteste.demo.dto.UserRequestDTO;
import br.com.crudteste.demo.model.User;
import br.com.crudteste.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.GetAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> GetUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody UserRequestDTO data) {
        User userData = new User(data);
        if(userData.getImageUrl() == null) {
            userData.setImageUrl("https://villagesonmacarthur.com/wp-content/uploads/2020/12/Blank-Avatar.png");
            userService.save(userData);
        } else {
            userService.save(userData);
        }
        return;
    }

    @PutMapping("/{id}")
    public void updateImg(@PathVariable Long id, @RequestBody UserRequestDTO data) {
        userService.updateUserImg(id, data.imgUrl());
    }

    
}

