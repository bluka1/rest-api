package com.bluka1.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "John", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Tommy", LocalDate.now().minusYears(40)));
        users.add(new User(3, "Charlie", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }


}
