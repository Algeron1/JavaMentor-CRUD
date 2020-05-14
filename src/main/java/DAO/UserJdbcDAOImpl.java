package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAOImpl implements UserDAO {

    private final Connection connection;

    public UserJdbcDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        PreparedStatement statement = connection.
                prepareStatement("create table if not exists users (id bigint auto_increment, name varchar(256), email varchar(256), workplace varchar(256), primary key (id))");
        statement.execute();
        statement.close();
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name2 = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String role = rs.getString("role");
            users.add(new User(id, name2, email, password, role));
        }
        return users;
    }

    @Override
    public User getUser(long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where id=?");
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String name2 = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            int id1 = rs.getInt("id");
            String role = rs.getString("role");
            return new User(id1, name2, email, password, role);
        }
        return null;
    }

    @Override
    public void addUser(User newUser) throws SQLException {
        if (newUser.getName().length() > 0 && newUser.getEmail().length() > 0) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email, password, role) Values (?, ?, ?, ?)");
            createTable();
            connection.setAutoCommit(true);
            statement.setString(1, newUser.getName());
            statement.setString(2, newUser.getEmail());
            statement.setString(3, newUser.getPassword());
            statement.setString(4, newUser.getRole());
            statement.execute();
            statement.close();
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "update users set name=?, email=?, password=?, role=? where id =?");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        stmt.setLong(5, user.getId());
        stmt.setString(4, user.getRole());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void deleteUser(long id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE id =?");
        stmt.setLong(1, id);
        stmt.execute();
    }

    @Override
    public boolean isExist(String email, String password) throws SQLException {
        List<User> users = getAllUser();
        for (User a : users) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRole(String email, String password) throws SQLException {
        List<User> users =getAllUser();
        for (User a:users){
            if(a.getEmail().equals(email) && a.getPassword().equals(password)){
                return a.getRole();
            }
        }
        return null;
    }

    @Override
    public User getUser(String email, String password) throws SQLException {
        List<User> users =getAllUser();
        for (User a:users){
            if(a.getEmail().equals(email) && a.getPassword().equals(password)){
                return a;
            }
        }
        return null;
    }
}
