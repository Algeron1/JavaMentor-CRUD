package DAO;

import DAOImpl.UserDAO;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private final Connection connection;

    UserJdbcDAO(Connection connection) {
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
            String workplace = rs.getString("workplace");
            String email = rs.getString("email");
            users.add(new User(id, name2, workplace, email));
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
            String workplace = rs.getString("workplace");
            int id1 = rs.getInt("id");
            return new User(id1, name2, workplace, email);
        }
        return null;
    }

    @Override
    public void addUser(User newUser) throws SQLException {
        if (newUser.getName().length() > 0 && newUser.getEmail().length() > 0) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email, workplace) Values (?, ?, ?)");
            createTable();
            connection.setAutoCommit(true);
            statement.setString(1, newUser.getName());
            statement.setString(2, newUser.getEmail());
            statement.setString(3, newUser.getWorkplace());
            statement.execute();
            statement.close();
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "update users set name=?, email=?, workplace=? where id =?");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getWorkplace());
        stmt.setLong(4, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void deleteUser(long id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE id =?");
        stmt.setLong(1, id);
        stmt.execute();
    }
}
