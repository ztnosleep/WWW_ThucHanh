package iuh.fit.lab04.daos;

import iuh.fit.lab04.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
}
