package DAO;

import DAOImpl.UserDAO;
import util.DBHelper;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {

    public UserDAO getRealizationByProperty() {
        if (getProperty().equalsIgnoreCase("jdbc")) return new UserJdbcDAO(DBHelper.getConnection());
        else if (getProperty().equalsIgnoreCase("jpa")) return new UserHibernateDAO(DBHelper.getSessionFactory());
        else throw new RuntimeException("UserDaoFactory - anything didn't match");
    }

    private String getProperty() {
        Properties prop = new Properties();
        String daotype = null;
        try {
            prop.load(UserDaoFactory.class.getClassLoader().getResourceAsStream("/config.properties"));
            daotype = prop.getProperty("daotype");
        } catch (IOException e) {
            System.out.println("Ошибка в properties, проверь путь к файлу!");
            e.printStackTrace();
        }
        return daotype;
    }
}

