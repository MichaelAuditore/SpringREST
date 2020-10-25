package com.example.api.repository;

import com.example.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * UserRepository - interface para consumir los metodos por defecto para
 * realizar cambios en DB del Objeto User tales como INSERTION, UPDATE, DELETION
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
