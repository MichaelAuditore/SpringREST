package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 *
 * MyController - Clase que contiene todos los endpoints de la aplicación
 *
 */
@RestController
public class MyController {

    @Autowired
    private UserService userService;

    /**
     *
     * allUsers - hace un llamado al método findAll del servicio User para traer
     * todos los usuarios registrados en H2 Database 
     * @return      List una lista de Objetos User
     *
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.findAll();
    }

    /**
     *
     * processUser - hace un llamado al método updateUser del servicio User para
     * actualizar datos de un usuario especifico obtenido mediante el id
     * @param id: User Id to update
     * @param user: Attributes to modify
     *
     */
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public void processUser(@PathVariable String id, @RequestBody User user) {
        Long userId = Long.parseLong(id);
        userService.updateUser(userId, user);
    }

    /**
     *
     * processUser - hace un llamado al método updateUser del servicio User para
     * actualizar datos de un usuario especifico obtenido mediante el id 
     * @param newUser: Attributes for new User Object
     * @return      User usuario creado
     *
     */
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/users", consumes = "application/json")
    public User addUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    /**
     *
     * processUser - hace un llamado al método deteById del servicio User para
     * eliminar un usario de H2 database
     * @param id: String id for user deletion
     *
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
    }
}
