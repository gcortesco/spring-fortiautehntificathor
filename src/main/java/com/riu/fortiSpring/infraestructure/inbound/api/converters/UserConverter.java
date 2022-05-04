package com.riu.fortiSpring.infraestructure.inbound.api.converters;

import com.riu.fortiSpring.infraestructure.inbound.api.model.UserRequest;
import com.riu.fortiSpring.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

    User convertCourseRequest(UserRequest userRequest);
}
