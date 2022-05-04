package com.riu.fortiSpring.domain.ports.secondary;

import com.riu.fortiSpring.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {

    List<User> findAll();

    User save(User course);
}
