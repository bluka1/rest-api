package com.bluka1.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "John", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Tommy", LocalDate.now().minusYears(40)));
        users.add(new User(++usersCount, "Charlie", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
