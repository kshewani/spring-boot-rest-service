package com.kam.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping(path="/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping(path="/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("id-"+id);
        }

        EntityModel<User> userModel = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
        userModel.add(linkToUsers.withRel("all-users"));
        return userModel;
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.deleteUser(id);
        if (user == null) {
            throw new UserNotFoundException("id-"+id);
        }
    }

    @PutMapping(path="/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
       User savedUser = service.save(user);
       URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
