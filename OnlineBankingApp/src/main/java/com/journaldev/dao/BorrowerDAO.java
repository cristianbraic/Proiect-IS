package com.journaldev.dao;

import com.journaldev.model.Borrower;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface BorrowerDAO {

    public void save(Borrower account);

    public List<Borrower> list();
}
