package com.riu.fortiSpring.ports.primary;

import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.domain.ports.secondary.UserRepository;
import com.riu.fortiSpring.application.UserListAndCreator;
import com.riu.fortiSpring.infraestructure.outbound.repository.adapter.CustomUserRespository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserServiceTest {

    private UserRepository repository = mock(CustomUserRespository.class);

    private UserListAndCreator sut = new UserListAndCreator(repository);

    private User user = mock(User.class);

    @Test
    public void shouldGetAllUsers() {
        sut.getAllUsers();

        verify(repository).findAll();
    }

    @Test
    public void shouldSaveUser() {
        sut.saveUser(user);

        verify(repository).save(user);
    }


}
