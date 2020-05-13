package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;


public class UserHibernateDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;


    public UserHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        List<User> users = (List<User>) session.createQuery("From User").list();
        session.close();
        return users;
    }

    @Override
    public User getUser(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteUser(long id) {
        User user = getUser(id);
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}