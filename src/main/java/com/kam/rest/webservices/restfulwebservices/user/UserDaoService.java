package com.kam.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();
    private static Integer userCount = 1;

    static {
        users.add(new User(userCount++, "Kam", new Date()));
        users.add(new User(userCount++, "Mon", new Date()));
        users.add(new User(userCount++, "Van", new Date()));
        users.add(new User(userCount++, "Suh", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User newUser) {
        if (newUser.getId() == null) {
            newUser.setId(userCount++);
        }
        users.add(newUser);
        return newUser;
    }

    public User findUser(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public User deleteUser(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
