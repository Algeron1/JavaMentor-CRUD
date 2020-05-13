package service;

import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;
import DAOImpl.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserHibernateDAO();

    public UserService() {
    }

    public List<User> getAllUser() {
        try {
            return userDAO.getAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public User getUser(int id) {
        try {
            return userDAO.getUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addUser(User newUser) {
        try {
            userDAO.addUser(newUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
