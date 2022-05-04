package com.riu.fortiSpring.adapters.secondary;

import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.infraestructure.outbound.repository.adapter.CustomUserRespository;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserRepositoryImplTest {

    private CustomUserRespository sut = new CustomUserRespository();

    private User course = new User("gcortes", "Gonzalo");

    @Before
    public void setup() {
        sut.addUser(new User("Usuario 1", "Name 1"));
        sut.addUser(new User("Usuario 2", "Name 2"));
        sut.addUser(new User("Usuario 3", "Name 3"));
    }

    @Test
    public void shouldObtainData() {
        List<User> allCourses = sut.findAll();

        assertEquals(allCourses.get(0).getUsername(), "Usuario 1");
        assertEquals(allCourses.get(1).getUsername(), "Usuario 2");
        assertEquals(allCourses.get(2).getUsername(), "Usuario 3");
    }

    @Test
    public void shouldSaveData() {
        User courseSave = sut.save(course);

        assertEquals(courseSave.getUsername(), "gcortes");
    }

}
