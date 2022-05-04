package com.riu.fortiSpring.infraestructure.outbound.repository.adapter;

import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.domain.ports.secondary.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserRespository implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User course) {
        return users.add(course) ? course : null;
    }

    public void addUser(User course) {
        users.add(course);
    }
}
