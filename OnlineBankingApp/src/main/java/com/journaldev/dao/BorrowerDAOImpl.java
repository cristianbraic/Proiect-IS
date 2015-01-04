package com.journaldev.dao;

import com.journaldev.model.Borrower;
import com.journaldev.model.Depositor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public class BorrowerDAOImpl implements BorrowerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Borrower borrower) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(borrower);
        tx.commit();
        session.close();
    }

    @Override
    public List<Borrower> list() {
        return null;
    }
}
