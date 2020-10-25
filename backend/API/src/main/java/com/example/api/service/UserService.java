package com.example.api.service;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        newUser.setProcesado(false);
        return userRepository.save(newUser);
    }

    public void updateUser(Long userId, User user) {
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
    }

    public List<User> findAll() {

        var it = userRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
