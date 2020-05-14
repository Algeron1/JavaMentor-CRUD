package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUser() throws SQLException;

    public User getUser(long id) throws SQLException;

    public void addUser(User user) throws SQLException;

    public void updateUser(User user) throws SQLException;

    public void deleteUser(long id) throws SQLException;

    public boolean isExist(String email, String password) throws SQLException;

    public String getRole(String email, String password) throws SQLException;

    public User getUser(String email, String password) throws SQLException;
}
