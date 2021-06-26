package com.kam.rest.webservices.restfulwebservices.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoServiceTest {
    UserDaoService service;

    @BeforeEach
    void setUp() {
        service = new UserDaoService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void findOne() {
        User user = service.findUser(1);
    }
}