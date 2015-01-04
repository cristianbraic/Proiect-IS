package com.journaldev.dao;

import com.journaldev.model.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public class LoanDAOImpl implements LoanDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Loan loan) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(loan);
        tx.commit();
        session.close();
    }

    @Override
    public List<Loan> list() {
        return null;
    }
}
