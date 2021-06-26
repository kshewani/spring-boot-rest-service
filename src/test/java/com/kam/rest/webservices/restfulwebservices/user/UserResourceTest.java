package com.kam.rest.webservices.restfulwebservices.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.EntityModel;

class UserResourceTest {
    UserResource userResource;

    @BeforeEach
    void setUp() {
        userResource = new UserResource();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUser() throws UserNotFoundException {
        EntityModel<User> u = userResource.getUser(1);
    }
}