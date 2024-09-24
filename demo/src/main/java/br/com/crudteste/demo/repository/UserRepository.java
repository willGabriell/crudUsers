package br.com.crudteste.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudteste.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
