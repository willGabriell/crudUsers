package br.com.crudteste.demo.service;

import br.com.crudteste.demo.model.User;
import br.com.crudteste.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> GetAllUsers() {
        return repository.findAll();

    }

    public Optional<User> getById(Long id){
        return repository.findById(id);
    }

    public void save(User user) {
        repository.save(user);
    }

    public void updateUserImg(Long id, String url){
        User user = repository.findById(id).orElseThrow();
        user.setImageUrl(url);
        repository.save(user);
    }
}
