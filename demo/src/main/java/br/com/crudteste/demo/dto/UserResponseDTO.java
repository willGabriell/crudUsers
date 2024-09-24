package br.com.crudteste.demo.dto;

import br.com.crudteste.demo.model.User;

public record UserResponseDTO(long id, String name, String email, String password, String imgUrl) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword(),user.getImageUrl());
    }
}
