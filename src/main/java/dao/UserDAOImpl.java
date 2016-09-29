package dao;

import java.util.List;

import model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void registerUser(UserAccount user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("UserAccount saved successfully, UserAccount Details=" + user);
    }

    @Override
    public void updateUser(UserAccount user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("UserAccount updated successfully, UserAccount Details=" + user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserAccount> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserAccount> usersList = session.createQuery("from UserAccount").list();
        for (UserAccount user : usersList) {
            logger.info("UserAccount List::" + user);
        }
        return usersList;
    }

    @Override
    public UserAccount getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserAccount user = (UserAccount) session.load(UserAccount.class, id);
        logger.info("UserAccount loaded successfully, UserAccount details=" + user);
        return user;
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserAccount user = (UserAccount) session.load(UserAccount.class, id);
        if (null != user) {
            session.delete(user);
        }
        logger.info("UserAccount deleted successfully, user details=" + user);
    }

}