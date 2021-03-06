package factory;

import DAO.UserDAO;
import DAO.UserHibernateDAOImpl;
import DAO.UserJdbcDAOImpl;
import util.DBHelper;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {

    public UserDAO getRealizationByProperty() {
        if (getProperty().equalsIgnoreCase("jdbc")) return new UserJdbcDAOImpl(DBHelper.getConnection());
        else if (getProperty().equalsIgnoreCase("jpa")) return new UserHibernateDAOImpl(DBHelper.getSessionFactory());
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

