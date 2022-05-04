package com.riu.fortiSpring.domain.ports.primary;

import com.riu.fortiSpring.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 public interface UserService {
    public List<User> getAllUsers();

    public ResponseEntity<User> saveUser(User course);

}
