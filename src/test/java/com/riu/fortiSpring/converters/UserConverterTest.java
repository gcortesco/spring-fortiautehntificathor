package com.riu.fortiSpring.converters;

import com.riu.fortiSpring.infraestructure.inbound.api.model.UserRequest;
import com.riu.fortiSpring.domain.User;
import com.riu.fortiSpring.infraestructure.inbound.api.converters.UserConverter;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.*;

public class UserConverterTest {

    User userExpected = new User("gcortes", "Gonzalo");
    UserRequest userRequest = new UserRequest("gcortes", "Gonzalo");
    UserConverter converter = Mappers.getMapper(UserConverter.class);


    @Test
    public void shouldConvertRequestToDomain() {
        User courseActual = converter.convertCourseRequest(userRequest);
        assertEquals(userExpected, courseActual);
    }

}
