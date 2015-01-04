package com.journaldev.dao;

import com.journaldev.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public class CustomerDAOImpl implements CustomerDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        session.close();
    }

    @Override
    public List<Customer> list() {
        return null;
    }
}
