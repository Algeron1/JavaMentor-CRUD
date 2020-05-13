package service;

import DAO.UserDaoFactory;

import java.sql.SQLException;
import java.util.List;


import DAOImpl.UserDAO;
import model.User;

public class UserService implements UserDAO {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = getUserDAO();
    }

    public UserDAO getUserDAO() {
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
}