package pl.brzezinski.weekop.dao;

import pl.brzezinski.weekop.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    List<User> getAll();
    User getUserByUsername(String username);
}
