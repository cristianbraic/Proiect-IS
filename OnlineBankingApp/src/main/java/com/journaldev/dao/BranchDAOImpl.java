package com.journaldev.dao;

import com.journaldev.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public class BranchDAOImpl implements BranchDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Branch branch) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(branch);
        tx.commit();
        session.close();
    }

    @Override
    public List<Branch> list() {
        return null;
    }
}
