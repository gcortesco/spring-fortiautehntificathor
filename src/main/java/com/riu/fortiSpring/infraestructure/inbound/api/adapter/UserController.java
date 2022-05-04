package com.riu.fortiSpring.infraestructure.inbound.api.adapter;

import com.riu.fortiSpring.infraestructure.inbound.api.model.UserRequest;
import com.riu.fortiSpring.infraestructure.inbound.api.converters.UserConverter;
import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.domain.ports.primary.UserService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Component
public class UserController {

    @Autowired
    private UserService userService;

    private UserConverter converter = Mappers.getMapper(UserConverter.class);

    public UserController() {

    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {
        User userConverted = converter.convertCourseRequest(userRequest);
        return userService.saveUser(userConverted);
    }
}
