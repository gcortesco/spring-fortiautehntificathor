package com.riu.fortiSpring.application;

import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.domain.ports.primary.UserService;
import com.riu.fortiSpring.domain.ports.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserListAndCreator implements UserService {
    @Autowired
    private UserRepository repository;

    public UserListAndCreator() {

    }

    public UserListAndCreator(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public ResponseEntity<User> saveUser(User user) {
        if(user.getName() == null) {
            return ResponseEntity.of(null);
        }else{
            User courseSaved = repository.save(user);
            return ResponseEntity.of(Optional.of(courseSaved));
        }
    }


}
