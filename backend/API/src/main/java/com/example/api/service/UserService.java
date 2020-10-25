package com.example.api.service;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * UserService - clase generada para relacoinar todos los metodos por defecto de
 * la interface y consumirlos para la modificacion de DB
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * createUser - crea un nuevo usuario
     *
     * @param newUser: Object to save in DB
     * @return      User creado en H2 DB
     */
    public User createUser(User newUser) {
        try {
            newUser.setProcesado(false);
            return userRepository.save(newUser);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     *
     * updateUser - actualiza o modifica datos de un usuario existente
     *
     * @param userId: Long user Id to update
     * @param user: Object to replace and update for user
     * 
     */
    public void updateUser(Long userId, User user) {
        try {
            User updateUser = userRepository.findById(userId).get();
            if (user.getNombre() != null) {
                updateUser.setNombre(user.getNombre());
            }
            if (user.getApellido() != null) {
                updateUser.setApellido(user.getApellido());
            }
            if (user.getProcesado() != null) {
                updateUser.setProcesado(user.getProcesado());
            }
            userRepository.save(updateUser);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * 
     * findAll - genera una lista de todos los registros encontrados en la DB
     * @return      una lista de Objetos tipo User
     * 
     */
    public List<User> findAll() {

        var it = userRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

    /**
     *
     * deleteById - elimina un registro existente en DB mediante el ID
     *
     * @param userId: user id para la eliminar
     * 
     */
    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
