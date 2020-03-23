package pl.brzezinski.weekop.service;

import pl.brzezinski.weekop.dao.UserDAO;
import pl.brzezinski.weekop.dao.factory.DAOFactory;
import pl.brzezinski.weekop.model.User;

public class UserService {
    public void addUser(String username, String email, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setIs_active(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.create(user);
    }

    public User getUserById(long userId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.read(userId);
        return user;
    }

    public User getUserByUsername(String username){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user =  userDAO.getUserByUsername(username);
        return user;
    }
}
