package com.journaldev.dao;

import com.journaldev.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public class AccountDAOImpl implements AccountDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Account account) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(account);
        tx.commit();
        session.close();
    }

    @Override
    public List<Account> list() {
        return null;
    }
}
