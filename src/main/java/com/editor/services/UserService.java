package com.editor.services;

import org.springframework.stereotype.Service;
import com.editor.models.User;
import com.editor.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Missing method added!
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        System.out.println("Saving User: " + user.getUsername());  // ✅ Debug print
        return userRepository.save(user);
    }

}
