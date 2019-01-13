package pl.pawel.gaudziak.kalkulacja.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pawel.gaudziak.kalkulacja.model.User;
import pl.pawel.gaudziak.kalkulacja.utils.HibernateUtils;

import java.util.List;

public class UserService {

    public List<User> getAllUser() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("SELECT k FROM User k").list();

        transaction.commit();
        session.close();
        return users;
    }

    public User login(String login, String haslo) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT k FROM User k WHERE k.login =:login AND k.haslo=:haslo");
        query.setString("login", login);
        query.setString("haslo", haslo);
        query.setMaxResults(1);
        User loggedUser = (User) query.uniqueResult();


        transaction.commit();
        session.close();
        return loggedUser;

    }
    public void save(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }


}

