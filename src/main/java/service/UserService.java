package service;

import factory.UserDaoFactory;

import java.sql.SQLException;
import java.util.List;


import DAO.UserDAO;
import model.User;

public class UserService implements UserDAO {

    private static UserDAO userDAO;

    public UserService() {
        this.userDAO = getUserDAO();
    }

    public static UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDaoFactory().getRealizationByProperty();
        }
        return userDAO;
    }

    @Override
    public List<User> getAllUser() {
        try {
            return userDAO.getAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(long id) {
        try {
            return userDAO.getUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(long id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean isExist(String email, String password) {
        try {
            return userDAO.isExist(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public String getRole(String email, String password) {
        try {
            return userDAO.getRole(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String email, String password) {
        try {
            return userDAO.getUser(email, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}