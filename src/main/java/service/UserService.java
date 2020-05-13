package service;

import DAO.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = UserDAO.getUserDAO();
    }

    public List<User> getAllUser() {
        try {
            return userDAO.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(int id) {
        try {
            return userDAO.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User newUser) {
        try {
            userDAO.addUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
