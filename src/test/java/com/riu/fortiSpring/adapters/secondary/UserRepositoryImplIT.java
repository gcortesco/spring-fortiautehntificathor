package com.riu.fortiSpring.adapters.secondary;

import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.infraestructure.outbound.repository.adapter.CustomUserRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc(addFilters=false)
@SpringBootTest
public class UserRepositoryImplIT {

    @Autowired
    public MockMvc mockMvc;

    CustomUserRespository userRepository = new CustomUserRespository();

    @Before
    public void setup(){
        userRepository.addUser(new User("gcortes", "Gonzalo"));
    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        mockMvc.perform(
                get("/users/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
