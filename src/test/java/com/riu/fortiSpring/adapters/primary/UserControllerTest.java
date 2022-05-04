package com.riu.fortiSpring.adapters.primary;

import com.riu.fortiSpring.infraestructure.inbound.api.model.UserRequest;
import com.riu.fortiSpring.domain.User;

import com.riu.fortiSpring.domain.ports.primary.UserService;
import com.riu.fortiSpring.infraestructure.inbound.api.adapter.UserController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserControllerTest {

    public UserService courseService = mock(UserService.class);

    public UserController sut = new UserController(courseService);

    public User course = mock(User.class);
    public UserRequest userRequest = mock(UserRequest.class);

    @Test
    public void shouldGetAllCourses() {
        sut.getAllUsers();

        verify(courseService).getAllUsers();
    }

    @Test
    public void shouldSaveCourse() {
        sut.saveUser(userRequest);

        verify(courseService).saveUser(course);
    }

}
